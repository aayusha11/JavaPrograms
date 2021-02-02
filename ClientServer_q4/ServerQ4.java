import java.net.*;
import java.io.*;
import java.util.Scanner;


public class ServerQ4 {

    static final int LISTENING_PORT = 3000;


    public static void main(String[] args) {

        File directory;
        ServerSocket listener;
        Socket connection;
        if (args.length == 0) {
            System.out.println("Enter directory path via command line!");
            return;
        }

        directory = new File(args[0]);
        if ( ! directory.exists() ) {
            System.out.println("Specified directory does not exist.");
            return;
        }
        if (! directory.isDirectory() ) {
            System.out.println("The specified file is not a directory.");
            return;
        }

       try {
            listener = new ServerSocket(LISTENING_PORT);
            System.out.println("Listening on port " + LISTENING_PORT);
            while (true) {
                connection = listener.accept();
                handleConnection(directory,connection);
            }
        }
        catch (Exception e) {
            System.out.println("Server shut down unexpectedly.");
            System.out.println("Error:  " + e);
            return;
        }

    }

    private static void handleConnection(File directory, Socket connection) {

        ObjectInputStream incoming;
        ObjectOutputStream outgoing;
        String command = "";
        try {
            incoming = new ObjectInputStream( connection.getInputStream() );
            outgoing = new ObjectOutputStream( connection.getOutputStream() );
            command = incoming.readObject().toString();

            if (command.equalsIgnoreCase("index")) {
                sendIndex(directory, outgoing);
            }

            else if (command.toLowerCase().startsWith("get")){
                String fileName = command.substring(3).trim();
                sendFile(fileName, directory, outgoing);
            }

            else {
                outgoing.writeObject("ERROR unsupported command");
                outgoing.flush();
            }

            System.out.println("OK    " + connection.getInetAddress()
                    + " " + command);
        }
        catch (Exception e) {
            System.out.println("ERROR " + connection.getInetAddress()
                    + " " + command + " " + e);
        }
        finally {
            try {
                connection.close();
            }
            catch (IOException e) {
            }
        }
    }


    private static void sendIndex(File directory, ObjectOutputStream outgoing) throws Exception {
        String[] fileList = directory.list();
        for (int i = 0; i < fileList.length; i++)
            outgoing.writeObject(fileList[i]);
        outgoing.flush();
        outgoing.close();

    }


    private static void sendFile(String fileName, File directory, ObjectOutputStream outgoing)
            throws Exception {
        File file = new File(directory,fileName);
        if ( (! file.exists()) || file.isDirectory() ) {
            outgoing.writeObject("ERROR");
        }
        else {
            outgoing.writeObject("OK");
            BufferedReader fileIn = new BufferedReader( new FileReader(file) );
            while (true) {
                String line = fileIn.readLine();
                if (line == null)
                    break;
                outgoing.writeObject(line);
            }
        }
        outgoing.flush();
        outgoing.close();
    }


} 

