import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        socket = new Socket(host, 3000);
        oos = new ObjectOutputStream(socket.getOutputStream());

        System.out.println("Sending request to Socket Server\nEnter your choice: ");
        String input = new String();
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        oos.writeObject(input);

        ois = new ObjectInputStream(socket.getInputStream());
        while (true){
            try {
                Object message = ois.readObject();
                if(Objects.isNull(message))
                    break;
                System.out.println(message.toString());
            }catch (EOFException e){
                System.out.println("Reached end of file");
                break;
            }

        }

        ois.close();
        oos.close();
    }
}

