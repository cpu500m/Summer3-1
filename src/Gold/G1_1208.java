// 흠.. 보고 생각나는 방식은
// 중간에서 만나기 말고는 딱히없네..
// n이 40이니깐
// 반반 쪼개면
// 일단 각각 넣는다 OR 안넣는다로 만들면 2^20 짜리 int배열이 두개 나올테고.
// 그러면 4MB * 2니깐 8MB 메모리는 ㅇㅋ임
// 그리고 시간복잡도를 생각해보면
// 이거도 뭐 말그대로 2^20 * 2번 도는거지? 그러면 8백만번
// 그리고나서
// 2^20 의 루프 동안 이분 탐색을 해야하는데
// 이는 2^20 * log 2^20 과 같음.
// 그러면 대략.. 2천만번루프
// 근데이제 경우의수를 구하려면 lower 와 upper를 구해야할거같음. 그럼 4천만번인데..
// 흠.. 내부연산까지 따져보면 좀 빡빡하긴하네
// 생각해보니깐 나중에 우측 집합 정렬도 해야하고. 그럼 그건 또 N log N 걸릴테고. 그럼 또 2천만번.

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1_1208 {
    static int[] left_arr;
    static int[] right_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*     입력 처리        */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        // index
        int i;

        st = new StringTokenizer(br.readLine());
        for( i = 0; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        /*      로직      */
        int left;
        // 결과
        long result = 0;
        if(N % 2 == 0)
            left = N/2;
        else left = N/2 +1;

        // 각각 넣냐 or 안넣느냐로 저장하자
        left_arr = new int[1<<left];
        right_arr = new int[1<<(N-left)];

        int mask = (1<<left)-1;
        // 좌측 부분 부분합 계산.
        while (mask > 0){
            left_arr[mask] = 0;
            for(i = 0 ; i < left ; i++){
                if((mask & (1<<i)) != 0)
                    left_arr[mask] += arr[i];
            }
            mask--;
        }
        // 우측 부분 부분합 계산
        mask = (1<<(N-left))-1;
        while (mask > 0){
            right_arr[mask] = 0;
            for(i = left ; i < N ; i++){
                if((mask & (1<<i-left)) != 0)
                    right_arr[mask] += arr[i];
            }
            mask--;
        }
        // 우측 부분합은 이분탐색을 수행해야 하므로 정렬.
        Arrays.sort(right_arr);

        int lower , upper;
        int target;
        for(i = 0 ; i < left_arr.length ; i++){
            target = S-left_arr[i];
            // 이분 탐색을 수행해야 함.
            lower = find_lower(target);
            upper = find_upper(target);
            result+= ( (long)upper-lower);
        }
        // S가 0이라면 둘다 0 인 경우는 빼야함. ( 아무것도 안넣은경우)
        if(result != 0 && S == 0)
            bw.write(String.valueOf(result-1));
        else bw.write(String.valueOf(result));
        bw.flush();
    }
    // lower니깐 타겟보다 가장 가깝게 작은곳에서 멈춰야한다 . 그니깐 3을
    // 찾는다고 하면 1 2 3 6 8 이면 2에서 멈춰야 함 ㅇㅇ
    static int find_lower(int target){
        int left = 0;
        int right = right_arr.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(target <= right_arr[mid])
                right = mid-1;
            else left = mid+1;
        }
        return left;
    }
    static int find_upper(int target){
        int left = 0;
        int right = right_arr.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(target >= right_arr[mid])
                left = mid+1;
            else right = mid-1;
        }
        return left;
    }
}
