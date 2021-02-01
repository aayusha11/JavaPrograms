import java.io.*;

class CountNoOfLines {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
             System.out.println("Enter filename");
          return;
      }
      
      for (int i = 0; i < args.length; i++) {
         System.out.print(args[i] + ":  ");
         countLines(args[i]);
      }
      
    }  
   
   public static void countLines(String fileName) {
          
      BufferedReader in;  
      int lineCount;      
      
      try {
          in = new BufferedReader( new FileReader(fileName) );
      }
      catch (Exception e) {
          System.out.println("Error: Unable to open file!");
          return;
      }
      
      lineCount = 0;
      
      try {
         String line = in.readLine();  
         while (line != null) {
             lineCount++;               
             line = in.readLine();   
         }
      }
      catch (Exception e) {
         System.out.println("Error: Unable to read files!");
         return;
      }
      
      System.out.println(lineCount + " lines");
   
   }  
}

