// 두 포인터 방식의 원리를 알고자 쉬운 문제 한번.. 몸풀기 느낌으로..
package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*  입력  처리  */
        // index
        int i , j;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(i = 0; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        /*      로직      */
        // 답
        int result = 0;
        // 포인터 두개를 이용하여 움직이는 형태.
        for(i = 0; i < N ; i++){
            int sum = arr[i];
            if(sum == M){
                result++;
                continue;
            }
            for(j = i+1 ; j < N ; j++){
                sum+=arr[j];
                if(sum > M)
                    break;
                else if(sum == M){
                    result++;
                    break;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
