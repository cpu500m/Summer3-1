package Bronze;

import java.io.*;

public class B5_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] check = new boolean[31];
        for (int i = 0; i < 28; i++) {
            check[Integer.parseInt(br.readLine())] = true;
        }
        for(int i = 1 ; i< check.length ; i++){
            if(!check[i]) bw.write(String.valueOf(i)+"\n");
        }
        bw.flush();
    }
}
