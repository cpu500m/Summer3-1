package Bronze;

import java.io.*;

public class B2_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력
        String str = br.readLine();
        if(str.equals("1 2 3 4 5 6 7 8"))
            bw.write("ascending");
        else if(str.equals("8 7 6 5 4 3 2 1"))
            bw.write("descending");
        else bw.write("mixed");
        bw.flush();
    }
}
