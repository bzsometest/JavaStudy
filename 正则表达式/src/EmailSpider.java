import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 邮箱爬虫程序
 */
public class EmailSpider {

    private static int count;

    public static void main(String[] args) {
        try {
            BufferedReader buf = new BufferedReader(new FileReader("email.html"));
            String line = "";
            while ((line = buf.readLine()) != null) {
                pase(line);
            }
            System.out.println("邮箱总数" + count );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void pase(String line) {
        // Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
        Pattern p = Pattern.compile("[\\w]+@[\\w]+\\.[\\w]+");
        Matcher m = p.matcher(line);
        while (m.find()) {
            count++;
            System.out.println(m.group());
        }
    }
}
