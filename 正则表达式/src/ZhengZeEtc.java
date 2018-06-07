import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 补充内容
 */
public class ZhengZeEtc {
    public static void main(String[] args) {
        fun3();
    }

    public static void fun1() {
        //以a结束，但不捕获a
        Pattern pattern = Pattern.compile(".{3}(?=a)");

        //  Pattern pattern = Pattern.compile("(?=a).{3}");

        //    Pattern pattern = Pattern.compile(".{3}(?<=a)");
        String s = "444a66a777";


        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println("rs:" + matcher.group());
        }
    }

    public static void fun2() {
        // \\1匹配成功够，后面也能匹配

        Pattern pattern = Pattern.compile("(\\d\\d)\\1");
        //匹配第二括号中的内容
        //  Pattern pattern = Pattern.compile("(\\d(\\d))\\2");

        String s = "121212a23a2335";


        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println("rs2:" + matcher.group());
        }
    }

    public static void fun3() {

        //不区分大小写
      //  Pattern pattern = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
        Pattern pattern = Pattern.compile("(?i)(Java)");//等同于上面的方法
        String s = "java5Java";

        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println("rs2:" + matcher.group());
        }
    }
}
