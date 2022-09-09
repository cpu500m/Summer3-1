package Bronze;

import java.io.*;

public class B2_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        int k = 0;
        while(N % 100 != 0)
            N--;
        while( N % F !=0){
            N++;
            k++;
        }
        if( k < 10)
            sb.append("0");
        sb.append(k);
        bw.write(sb.toString());
        bw.flush();
    }
}
