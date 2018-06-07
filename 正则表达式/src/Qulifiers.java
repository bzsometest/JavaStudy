import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Qulifiers限定语
 */
public class Qulifiers {
    public static void main(String[] args) {
//一个？ 代表从最小的数量开始，没有？从最大的量开始，+代表最大的不吐出
        Pattern pattern = Pattern.compile("(.{3,10}?)[0-9]");
        String s="abcd5abcd6";
        Matcher matcher = pattern.matcher(s);
        System.out.println("rs:"+matcher.find()+","+matcher.group());
    }
}
