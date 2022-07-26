// 처음에 생각한건
// 1행 1열 .1행 2열 . 1행 3열 ... 이런식으로 쭉 누적합을 구해서
// 행단위로 연산해서 최종적인 값으 구하는 것.
// 이렇게 해도 시간제한을 통과하면서 맞긴 했음.
// 하지만 시간이 좀 타이트해서 구글링 해 봤음.
package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S1_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][N+1];
        int[][] cum_sum = new int[N+1][N+1];
        int x1,y1,x2,y2;
        for(int i= 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                cum_sum[i][j] = cum_sum[i][j-1]+cum_sum[i-1][j]-cum_sum[i-1][j-1]+arr[i][j];
            }
        }
        for(int i = 0 ; i <M ; i++){
            st= new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            sb.append(cum_sum[x2][y2]-cum_sum[x2][y1-1]-cum_sum[x1-1][y2]+cum_sum[x1-1][y1-1]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

    // 아래는 처음에 푼 방식
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int[][] arr = new int[N+1][N+1];
//        int[][] cum_sum = new int[N+1][N+1];
//        int x1,y1,x2,y2;
//        int sum;
//        for(int i= 1; i <= N ; i++) {
//            st = new StringTokenizer(br.readLine());
//            cum_sum[i][0]=cum_sum[i-1][N];
//            for (int j = 1; j <= N; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//                cum_sum[i][j] = cum_sum[i][j-1]+arr[i][j];
//            }
//        }
//        for(int i = 0 ; i <M ; i++){
//            st= new StringTokenizer(br.readLine());
//            x1 = Integer.parseInt(st.nextToken());
//            y1 = Integer.parseInt(st.nextToken());
//            x2 = Integer.parseInt(st.nextToken());
//            y2 = Integer.parseInt(st.nextToken());
//            sum = 0;
//            for(int a = x1 ; a <= x2; a++){
//                sum+=( cum_sum[a][y2]-cum_sum[a][y1-1]);
//            }
//            sb.append(sum+"\n");
//        }
//        bw.write(sb.toString());
//        bw.flush();
//    }
