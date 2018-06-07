import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhengZE {
    public static void main(String[] args) {
        fun2();
    }

    public static void fun1() {
        //email . 匹配除换行符以外的任意字符,所以必须用转译字符
        p("email", "aaa@ss&com".matches("[\\w]+@[\\w]+.[\\w]+"));
        p("email2", "aaa@ss.com".matches("[\\w]+@[\\w]+\\.[\\w]+"));

        p("email3", "成的@ss.com".matches("[\\w.-]+@[\\w]+\\.[\\w]+"));


        Pattern p = Pattern.compile("\\d{3,5}");
        String str = "123-4567-890";
        Matcher mat = p.matcher(str);
        p("matches()", mat.matches());

        mat.reset();
//从当前位置查找
        p("find()", mat.find() + "," + mat.start() + "-" + mat.end());
        p("find()", mat.find() + "," + mat.start() + "-" + mat.end());
        // mat.reset() 必须能够找到才能输出start end
        p("find()", mat.find() + "," + mat.start() + "-" + mat.end());


        //从开始位置查找
        p("lookAt", mat.lookingAt());
        p("lookAt", mat.lookingAt());
        p("lookAt", mat.lookingAt());
    }

    public static void fun2() {
        Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher("Java java JavA ILoveJava you hatejava asdf");

        //将所有java大写
        p("replace", m.replaceAll("JAVA"));

        while (m.find()) {
            p("aa:", m.group());
        }
        m.reset();
        StringBuffer buf = new StringBuffer();
        int i = 0;
        while (m.find()) {
            i++;
            if (i % 2 == 0) {
                m.appendReplacement(buf, "java");
            } else {
                m.appendReplacement(buf, "JAVA");
            }
        }
        m.appendTail(buf);
        p("buf",buf);
    }

    public static void p(String str, Object o) {
        System.out.println(str + ":" + o);
    }
}
