package Bronze;

import java.io.*;
import java.time.LocalDate;

public class B5_16170 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LocalDate now = LocalDate.now();
        bw.write(now.getYear()+"\n");
        bw.write(now.getMonthValue()+"\n");
        bw.write(String.valueOf(now.getDayOfMonth()));
        bw.flush();
    }
}
