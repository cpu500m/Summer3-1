package Bronze;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B5_7287 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("702");
        bw.write("cpu500m");
        bw.flush();
    }
}
