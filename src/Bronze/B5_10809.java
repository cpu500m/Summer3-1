package Bronze;

import java.io.*;

public class B5_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        for(char c = 'a' ; c <='z'; c++)
            bw.write(str.indexOf(c)+" ");
        bw.flush();
    }
}

