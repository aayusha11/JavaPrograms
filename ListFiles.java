import java.io.File;
import java.util.Scanner;

public class ListFiles {
    public static void main(String[] args) {
        System.out.println("Enter address!");
        Scanner sc = new Scanner(System.in);
        String pathName = sc.next();
        File file = new File(pathName);
        String[] fileList = file.list();
        for(String name:fileList){
            System.out.println(name);
        }
    }
}
