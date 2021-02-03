import java.net.URL;
import java.net.URLConnection;

public class WikiHeadings {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.wikipedia.org/");
            URLConnection uc = url.openConnection();
            int i = 0;
            while(!uc.getHeaderField(i).isEmpty()){
                System.out.println(uc.getHeaderFieldKey(i)+": "+uc.getHeaderField(i));
                i++;
            }
        } catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
}



