package Bronze;

import java.io.*;

public class B1_30455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(Integer.parseInt(br.readLine()) % 2 == 0)
            bw.write("Duck");
        else bw.write("Goose");
        bw.flush();
    }
}
