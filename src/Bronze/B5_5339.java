package Bronze;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class B5_5339 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("     /~\\\n");
        bw.write("    ( oo|\n");
        bw.write("    _\\=/_\n");
        bw.write("   /  _  \\\n");
        bw.write("  //|/.\\|\\\\\n");
        bw.write(" ||  \\ /  ||\n");
        bw.write("============\n");
        bw.write("|          |\n");
        bw.write("|          |\n");
        bw.write("|          |\n");

        bw.flush();
    }
}
