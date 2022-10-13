package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <M; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <M; j++)
                matrix[i][j] += Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <N; i++){
            for(int j = 0; j <M; j++)
                sb.append(matrix[i][j]+" ");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
