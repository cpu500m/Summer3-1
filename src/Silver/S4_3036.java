package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int ring_count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ring = new int[ring_count-1];
        int standard_ring = Integer.parseInt(st.nextToken());
        int gcf;
        for(int i = 0 ; i < ring_count-1; i++) {
            ring[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i <ring_count-1; i++){
            gcf = euclidean(standard_ring,ring[i]);
            sb.append(standard_ring/gcf+"/"+ring[i]/gcf+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int euclidean(int a, int b){
        int temp, A = a, B = b;
        while(A % B !=0){
            temp =B;
            B = A % B;
            A = temp;
        }
        return B;
    }
}
