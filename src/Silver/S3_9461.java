// 보니까 계속 5변을 돌아가면서 새로운 삼각형이 붙으며 5번째 이전 삼각형과 그전 삼각형 변길이를 합치는식으로 가는 구조임.
package Silver;

import java.io.*;

public class S3_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int loop_count = Integer.parseInt(br.readLine());
        int n;
        long[] arr = new long[101];
        arr[1]=1; arr[2]=1;arr[3]=1;arr[4] =2;arr[5]=2;
        for(int i = 6; i <= 100 ; i++)
            arr[i]=arr[i-1]+arr[i-5];
        for(int i = 0 ; i <loop_count; i++){
            n =Integer.parseInt(br.readLine());
            sb.append(arr[n]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
