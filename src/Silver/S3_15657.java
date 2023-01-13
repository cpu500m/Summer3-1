package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_15657 {
    static StringBuilder sb;
    static int[] arr;
    static int[] temp;

    static int N,M, cur_length = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        // index
        int i ;

        /*      입력 처리       */
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        temp = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        /*      로직      */
        Arrays.sort(arr);

        temp[0] = 0;
        sequence();
        bw.write(sb.toString());
        bw.flush();
    }
    static void sequence(){
        // index
        int i,j;
        if(cur_length == M+1){
            for( i = 1 ; i <= M ; i++){
                sb.append(temp[i]+" ");
            }
            sb.append("\n");
            return ;
        }
        for (i = 0; i < N; i++) {
            if(temp[cur_length-1] <= arr[i]) {
                temp[cur_length++] = arr[i];
                sequence();
                cur_length--;
            }
        }
    }
}
