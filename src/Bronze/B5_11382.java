package Bronze;

import java.io.*;
import java.util.Scanner;

public class B5_11382 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        bw.write(String.valueOf(sc.nextLong() + sc.nextLong() + sc.nextLong()));
        bw.flush();
    }
}
