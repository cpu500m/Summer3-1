// 루프를 돌리면서 반복적으로 i번쨰부터 j번쨰까지 합을 구해서
// 출력하는 방식대로 했더니 예상대로 시간초과 발생 ( 최악의 경우 1,000번 * 100,000번 돌테니)
// 그래서 다시 생각해본 방식은
// N개의 수가 주어졌다 햇을 때
// 1번쨰부터 1번째. 1번쨰부터 2번째. ... 1번째부터 N번째까지 더한 값을 저장한 배열을 하나 만들어 놓음. ( 다 더해도 최악의경우 1,000 * 100,000이니 Int범위 내)
// 그리고 구간 범위가 N/2보다 크다면 누적합을 저장한 배열을 이용.
// N/2보다 작다면 그냥 일일이 더함.
// 이렇게 하면 최악의 경우 100,000번의 루프 * 500번의 연산 = 5천만번의 연산으로 시간제한을 통과할 수 있을것이라고 생각함.
// 이렇게 풀고나서 찾아봤는데 그냥 일일이 뺄 필요가 없었음....
package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S3_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start, end;
        int[] cumulated_sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++)
            cumulated_sum[i] = cumulated_sum[i-1]+Integer.parseInt(st.nextToken());

        while(M > 0 ){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            sb.append(cumulated_sum[end]-cumulated_sum[start-1]+"\n");
            M--;
        }
        bw.write(sb.toString());
        bw.flush();
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int sum;
//        int start, end;
//        int[] arr = new int[N];
//        int[] cumulated_sum = new int[N];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0 ; i < N; i++)
//            arr[i] = Integer.parseInt(st.nextToken());
//        cumulated_sum[0] = arr[0];
//        for(int i = 1; i < N ; i++){
//            cumulated_sum[i] = cumulated_sum[i-1]+arr[i];
//        }
//        while(M > 0 ){
//            st = new StringTokenizer(br.readLine());
//            sum=0;
//            start = Integer.parseInt(st.nextToken())-1;
//            end = Integer.parseInt(st.nextToken());
//            if( end - start  > N/2){
//                sum = cumulated_sum[end-1];
//                for(int i = 0 ; i < start ; i++)
//                    sum-=arr[i];
//                sb.append(sum+"\n");
//                M--;
//            }
//            else {
//                for (int i = start; i < end; i++)
//                    sum += arr[i];
//                sb.append(sum + "\n");
//                M--;
//            }
//        }
//        bw.write(sb.toString());
//        bw.flush();
//    }
}
