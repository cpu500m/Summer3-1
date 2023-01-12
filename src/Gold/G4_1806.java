// 10만. . int 형 배열을 하나 생성하면
// 400,000 bytes 니까 400KB 흠.. 일단 이러한 배열 많이 생성해도 되겠구나 정도 인지하자
// 시간 복잡도를 따져봐야하는데.. 시간제한이 0.5초라는 점에서 N log n 내지의 시간복잡도를 작성해야할 것 같네.
// 그러면 ..
// 흠.. 누적합 구해놓고 매개변수 이분탐색을 한번해볼까?

package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G4_1806 {
    static int[] arr;
    static int[] sum;
    static int N ,S;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index . mid가 정답
        int i ,start , end , mid = 0;


        /*      입력 처리       */
        StringTokenizer st=  new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        sum = new int[N+1];

        sum[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+arr[i];
        }

        if(sum[N] < S)
            bw.write("0");
        else{
            start = 1;
            end = N+1;
            while (start < end){
                mid = (start+end)/2;
                // 만약 길이 mid만큼의 부분합이 있다면
                // end를 반 줄여준다.
                if(search(mid))
                    end = mid;
                else start = mid+1;
            }
            bw.write(String.valueOf(result));
        }
        bw.flush();
    }
    static boolean search(int mid){
        // index
        int i;
        for(i = mid; i <=N ;i++){
            if(sum[i] -sum[i-mid] >= S) {
                result = mid;
                return true;
            }
        }
        return false;
    }
}
