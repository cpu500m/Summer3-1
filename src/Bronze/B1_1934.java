package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int loop_count = Integer.parseInt(br.readLine());
        int A, B;
        int max;
        for(int i = 0 ; i < loop_count ; i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            max = euclidean(A,B);
            sb.append((A*B)/max+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int euclidean(int A, int B){
        int temp, a= A, b= B;
        while(a % b != 0){
            temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }
}
