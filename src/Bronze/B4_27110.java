package Bronze;

import java.io.*;

public class B4_27110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        int res = 0 ;
        for(int i = 0 ; i < 3 ; i++){
            int c = Integer.parseInt(a[i]);
            if(c >= N) res += N;
            else res+= c;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
