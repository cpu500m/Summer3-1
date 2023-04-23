package Bronze;

import java.io.*;

public class B4_5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] a = br.readLine().split(" ");
        int score1 = 0;
        int score2 = 0;
        for(int i = 0 ; i < a.length ; i++)
            score1 += Integer.parseInt(a[i]);
        a =  br.readLine().split(" ");
        for(int i = 0 ; i < a.length ; i++)
            score2 += Integer.parseInt(a[i]);
        bw.write(score1 > score2 ? String.valueOf(score1) : String.valueOf(score2));
        bw.flush();

    }
}
