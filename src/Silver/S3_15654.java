package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_15654 {
    static StringBuilder sb;
    static int[] arr;
    static int[] temp;
    static boolean[] check;
    static int N,M, cur_length = 0;
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
        check = new boolean[N];
        temp = new int[M];
        st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        /*      로직      */
        Arrays.sort(arr);

        sequence();
        bw.write(sb.toString());
        bw.flush();
    }
    static void sequence(){
        // index
        int i,j;
        if(cur_length == M){
            for( i = 0 ; i < M ; i++){
                sb.append(temp[i]+" ");
            }
            sb.append("\n");
            return ;
        }
        for (i = 0; i < N; i++) {
            if(check[i]== false) {
                check[i] = true;
                temp[cur_length++] = arr[i];
                sequence();
                check[i] = false;
                cur_length--;
            }
        }
    }
}
