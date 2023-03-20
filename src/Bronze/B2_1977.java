package Bronze;

import java.io.*;

public class B2_1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int start = (int)Math.sqrt(M);
        int val = 0;
        boolean first = false;

        if(start*start != M) {
            start++;
        }
        while (start*start <= N){
            sum += start*start;
            start++;
            if(!first){
                first = true;
                val = sum;
            }
        }

        if(first)
            bw.write(String.valueOf(sum) + "\n"+String.valueOf(val));
        else bw.write("-1");
        bw.flush();
    }
}
