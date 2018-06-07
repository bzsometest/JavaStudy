import java.io.*;

/**
 * 代码统计
 */
public class CodeCounter {


    public static void main(String[] args) {
        File file = new File("src");
        File[] codeFiles = file.listFiles();

        System.out.println("文件数：" + codeFiles.length);
        for (File codeFile : codeFiles) {
            System.out.println("\n" + codeFile.getName());
            if (codeFile.getName().matches(".*\\.java$")) {
                parse(codeFile);
            }
        }
    }

    private static void parse(File file) {
        long commentLines = 0;
        long codeLines = 0;
        long whitelLines = 0;
        BufferedReader buf = null;
        boolean comment = false;
        try {
            buf = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = buf.readLine()) != null) {
                if (line.matches("^[\\s&&[^\\n]]*$")) {//已经去掉了换行符
                    whitelLines++;
                } else if (line.trim().startsWith("/*") && !line.endsWith("/*")) {//多行注释
                    commentLines++;
                    comment = true;
                } else if (line.trim().startsWith("/*") && line.endsWith("*/")) {//多行注释用于一行
                    commentLines++;
                    comment = true;
                } else if (true == comment) {
                    commentLines++;
                    if (line.endsWith("*/")) {
                        comment = false;
                    }
                }else if (line.trim().startsWith("//") && !line.endsWith("/*")) {//单行行注释
                    commentLines++;
                    comment = true;
                }  else {
                    codeLines++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("whiteLines：" + whitelLines);
        System.out.println("commentLines：" + commentLines);
        System.out.println("codeLines：" + codeLines);
    }
}