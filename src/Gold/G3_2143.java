// 흠..
// 포인터 각 배열에 두개씩 놓은다음에 구간합을 계산해서
// 타겟 기준으로 큰지 작은지를 조사해서 해야겠다는 생각이 대충 들긴하는데..
// 일단 좀 생각을 해보면
// 일단 A배열의 스타트 지점은 고징셔켜 놓는다고 해보자. 그러니깐 총 999번 고정해야겠지
// 그리고 999번 루프 각각 안에서 A배열 끝 포인터는 맨 뒤에 위치시키고
// A배열 끝 포인터가 앞으로 한칸씩 이동하면서
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*      입력  처리      */

        int T = Integer.parseInt(br.readLine());
        int n =  Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++)
            A[i] =  Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++)
            B[i] = Integer.parseInt(st.nextToken());

        // 1. 일단 모든 가짓수를 포함하는 배열을 생성한다.
        int a_size , b_size;
        if( n % 2 == 0)
            a_size = (n+1)*(n/2);
        else a_size = (n+1)*(n/2)+(n+1)/2;

        if(m %2 == 0)
            b_size = (m+1)*(m/2);
        else b_size = (m+1)*(m/2)+(m+1)/2;
        int[] a_total = new int[a_size];
        int[] b_total = new int[b_size];

        int cur_idx = 0;
        int sum;
        // a 부분
        for(int i =0 ; i < n ; i++){
            // 누적 값
            sum = 0;
            for(int j = i ; j < n ; j++){
                sum += A[j];
                a_total[cur_idx++] = sum;
            }
        }
        // b 부분
        cur_idx = 0;
        for(int i =0 ; i < m ; i++){
            // 누적 값
            sum = 0;
            for(int j = i ; j < m ; j++){
                sum += B[j];
                b_total[cur_idx++] = sum;
            }
        }

        // 이제.. 이분탐색을 하면됨. 그전에 정렬
        Arrays.sort(b_total);
        long res = 0;
        for(int i = 0 ; i< a_size ; i++){
            int target = T - a_total[i];
            int min_idx = get_min_idx(target,b_total);
            int max_idx = get_max_idx(target,b_total);
            res += (max_idx - min_idx);
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
    static int get_min_idx(int target,int[] arr){
        int left = 0 ;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left+right)>>1;
            if(arr[mid] >= target)
                right = mid-1;
            else left = mid+1;
        }
        return right;
    }
    static int get_max_idx(int target, int[] arr){
        int left = 0 ;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left+right)>>1;
            if(arr[mid] <= target)
                left = mid+1;
            else right = mid-1;
        }
        return right;
    }
}
