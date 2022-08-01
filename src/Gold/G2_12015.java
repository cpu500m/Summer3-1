// 이분탐색을 이용. G2_12738도 이와 코드 동일
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_12015 {
    private static int[] arr;
    private static int[] LIS;
    private static int LIS_length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        LIS = new int[N+1];
        Arrays.fill(LIS,Integer.MAX_VALUE);
        LIS_length = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > LIS[LIS_length]){
                LIS[++LIS_length] = arr[i];
            }
            else
                getLIS(i);
        }
        bw.write(String.valueOf(LIS_length));
        bw.flush();
    }
    private static void getLIS(int N) {
       int lower_bound = 1;
       int upper_bound = LIS_length;
       while(lower_bound < upper_bound){
           int mid = (lower_bound+upper_bound)/2;
           if(LIS[mid] < arr[N]){
               lower_bound = mid+1;
           }
           else
               upper_bound = mid;
       }
       LIS[lower_bound] = arr[N];
    }
}
