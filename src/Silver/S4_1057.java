package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int idx1 = Integer.parseInt(st.nextToken());
        int idx2 = Integer.parseInt(st.nextToken());
        if( idx1 > idx2){
            int temp = idx2;
            idx2 = idx1;
            idx1 = temp;
        }

        int round = 1;
        while (true) {
            if(idx2-1 == idx1 && (idx1 % 2 !=0 && idx2 % 2 == 0))
                break;
            idx1 = (idx1 + 1) / 2;
            idx2 = (idx2 + 1) / 2;
            round++;
        }
        bw.write(String.valueOf(round));
        bw.flush();
    }
}
