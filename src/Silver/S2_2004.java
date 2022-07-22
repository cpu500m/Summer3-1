package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t_cnt = countTwo(N) - countTwo(N-M) - countTwo(M);
        int f_cnt = countFive(N) - countFive(N-M) - countFive(M);
        bw.write(String.valueOf(Math.min(t_cnt,f_cnt)));
        bw.flush();
    }
    public static int countTwo(int N){
        int cnt = 0;
        while(N >= 2){
            cnt+= N/2;
            N/=2;
        }
        return cnt;
    }
    public static int countFive(int N){
        int cnt = 0;
        while(N >= 5){
            cnt+= N/5;
            N/=5;
        }
        return cnt;
    }
}
