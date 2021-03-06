package by.it.levchuk.levchuk.jd01_14;

/*crash-noobik
Liauchuk Aliaksandr*/

import java.io.*;


public class TaskA {

    public static final String USER_DIR = "user.dir";

    private static String dir() {
        String path = System.getProperty(USER_DIR) + File.separator + "src" + File.separator;
        String clDir = TaskA.class.getName()
                .replace(TaskA.class.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        DataOutputStream doc = null;
        try {
            doc = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dir() + "dataTaskA.bin"))
            );
            for (int i = 0; i < 20; i++) {
                doc.writeInt((int) (Math.random() * 25));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (doc != null) {
                try {
                    doc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try (DataInputStream inp = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(dir() + "dataTaskA.bin")));
             PrintWriter out2 = new PrintWriter(new FileWriter(dir() + "resultTaskA.txt"))
        ) {
            double sum = 0;
            double count = 0;
            while (inp.available() > 0) {
                int i = inp.readInt();
                System.out.print(i + " ");
                out2.println(i + " ");
                sum = sum + i;
                count++;
            }
            System.out.println("\navg=" + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
