import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        fun6();
    }

    public static void p(Object o) {
        System.out.println(o);
    }

    public static void p(String str, Object o) {
        System.out.println(str + ":" + o);
    }

    public static void fun1() {
        p("abc".matches("..."));
        p("abc222".replaceAll("[0-9]", "-"));

        Pattern pattern = Pattern.compile("[a-z]{3}");
        Matcher matcher = pattern.matcher("fas");
        p(matcher.matches());
        p("fas".matches("[a-z]{3}"));
    }

    public static void fun2() {
        //初步认识 . * ?
        p("a", "a".matches("."));
        p("aa", "aa".matches("aa"));
        p("aaa", "aaa".matches("a*"));
        p("aaaa+", "aaaa".matches("a+"));
        p("aaaa?", "aaaa".matches("a?"));

        p("a*", "a".matches("a*"));
        p("aaaa?", "aaaa".matches("a?"));
        p("?", "".matches("a?"));
        p("a?", "a".matches("a?"));


        p("234123423412341234", "2134213412341234".matches("\\d{3,100}"));
        p("192.168.11.aaa", "192.168.11.11".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));

        p("192", "192".matches("[0-2][0-9][0-9]"));
    }

    public static void fun3() {
        //范围
        p("ad", "z".matches("[azdc]"));
        p("d", "d".matches("[^abc]"));

        //下面三种都是去或
        p("A", "A".matches("[a-zA-Z]"));
        p("A", "A".matches("[a-z]|[A-Z]"));
        p("A", "A".matches("[a-z[A-Z]]"));

        p("B", "B".matches("[A-Z&&[PRG]]"));
    }

    public static void fun4() {
        //其他字符
        p("空白字符", " \n\r\t".matches("\\s{4}"));
        p("非空白字符", "@".matches("\\S"));

        //[a-zA-Z0-9_]
        p("a_8", "a_8".matches("\\w{3}"));
        p("abc888&^%", "abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));

        //匹配一个反斜线 java中四个反斜线代表两个反斜线，正则表达式本身也要匹配一个反斜线
        p("\\", "\\".matches("\\\\"));
    }

    public static void fun5() {
        // POSIX Style
        //[a-2]
        p("D", "a".matches("\\p{Lower}"));
    }

    public static void fun6() {
        //边界处理
        //. 匹配除换行符以外的任意字符 h（.*）
        p("hello sir", "hello sir".matches("^h.*"));
        //( .*)ir$
        p("hello sir", "hello sir".matches("^.*ir$"));
        //^匹配开头
        p("ahello sir", "ahello sir".matches("h[a-z]{1,3}o\\b.*"));
        p("hello sir", "hello sir".matches("^h[a-z]{1,3}o\\b.*"));
        p("hellosir", "hellosir".matches("^h[a-z]{1,3}o\\b.*"));

        //white lines 空白行
        p(" \n", " \n".matches("^[\\s&&[^\\n]]*\\n$"));
    }
}

