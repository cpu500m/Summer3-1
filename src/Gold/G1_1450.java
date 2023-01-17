// 7453번 푸는김에
// 중간에서 만나기형태의 알고리즘에 익숙해질겸 이거도 한번 풀어봄..
// 흠.. 그냥 넣거나 안넣거나 하면 N이 최대 30이니깐
// 2^30..
// 절반 절반 쪼개서보면
// 2 * 2^15 일테고..
// 근데 어떻게 쪼개지?
// 흠 절반절반 쪼개서
// 2^15개를 구한다면 .. ( 합)
// 아 머리아프네
// 그니깐 절반절반 쪼개서 각각에 대해 2^15가지를 모두 구하는거임. ( 넣냐 안넣냐) 그러면 만드는 과정에서..
// 2* 15*2^15 만큼의 루프고.
// 그리고 이제 절반절반 쪼갰을때 왼쪽에서 하나씩 선택하면서 루프를돌면 외부 루프는 2^15
// 내부에서 정렬된 오른쪽에 대해 이분탐색을 진행하면서 담을 수 있는 상한을 찾는다면 log2 2^15일테고
// 그러면.. 총 복잡도는 2*2^15 + 2* 2^15 * log2 2^15 (sorting) + 2*15 * log2 2^15
// 대충 .. 생각해보면 천만은 ,, 안넘을듯 이대로 하자

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1_1450 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*      입력  처리      */
        //index
        int i, j, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] weight = new int[N];

        st = new StringTokenizer(br.readLine());
        for( i = 0 ; i < N ;i++)
            weight[i] =  Integer.parseInt(st.nextToken());

        /*      로직      */
        // 우선.. 일단 weight를 정렬하자 별 의미는 없을 것 같지만 얼마안걸리니까
        Arrays.sort(weight);
        // weight를 절반절반 나누자
        int left;
        // N이 홀수라면.. 예를들어 7이면 왼쪽 4 오른쪽 3으로 쪼개자
        if( N % 2 !=0)
            left = (N/2)+1;
        else left = N/2;
        long[] sum1 = new long[(int)Math.pow(2,left)];
        long[] sum2 = new long[(int)Math.pow(2,N-left)];
        Arrays.fill(sum1,0);
        Arrays.fill(sum2 , 0);

        // 좌측 처리
        int mask = (int)Math.pow(2,left)-1;
        while (mask >= 0){
            for( i = 0 ; i < left ; i++){
                if( (mask  & (1<<i)) == 0)
                    continue;
                sum1[mask] += weight[i];
            }
            mask--;
        }

        //우측 처리
        mask = (int)Math.pow(2,N-left)-1;
        while (mask >= 0){
            for( i = left ; i < N ; i++){
                if( (mask  & (1<<(i-left))) == 0)
                    continue;
                sum2[mask] += weight[i];
            }
            mask--;
        }

        // sum2를 정렬.
        Arrays.sort(sum2);

        // 이분 탐색을 수행.
        long target;
        // 결과값
        long count = 0;
        for(i =0 ; i < sum1.length ; i++){
            target = C - sum1[i];
            int lower = 0;
            int upper = sum2.length-1;
            while (lower <= upper){
                int mid = (lower+upper)/2;
                if(sum2[mid] <= target)
                    lower = mid+1;
                else upper = mid-1;
            }
            count += lower;
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
