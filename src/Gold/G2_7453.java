// 아니... 당황스러운 문제네
// 일단 메모리 제한이 1024MB, 시간 제한이 12초..
// 흠.. 4개를 각각 포인터 하나씩 둬서 조사하면은
// 최악의 경우 O(N^4).
// N이 4000이면 4000^4 이거는 무조건 시간초과
// 그러면 .. 모르겠다 ; 그래서 알고리즘 분류를 봤음.
// 중간에서 만나기 라는 방식이 있어서 그게 뭐지? 하고 찾아봤는데
// 조사 대상을 절반으로 줄여서
// 이분 탐색과 함께 묶어서 해를 찾아내는 방식이었음.
// 흠 그렇게보니깐 좀 알겠다
// 이게 2개씩 배열을 합치면
// 4000*4000*4bytes니깐 약.. 64MB
// 2개면 128MB
// 합치는데 걸리는 시간은 2*N^2 = 3200만번 루프
// 그리고 합친 두개를 소팅하고 (각각을 X,Y라고 놓음)
// X의 0번째 원소의 inverse값을 Y에서 찾기위해 Y에서 이분 탐색을하는데
// 흠.. 그러면 1600만 * log2 1600만 이니깐... 되는건가?
// 모르겠네? ㅋㅋ
// 그래서 계산기 넣어서 돌려보니깐 log2 1600만이 약 24임
// 그러면 1600만 *24 는 ....
// 뭐 넉넉히 될거같음 12초니깐
// 이대로 ㄱㄱ

// 근데 틀려서 왜틀렸지 생각해보니깐 X원소 하나당 Y원소 하나가 매칭되라는법은 없구나..

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_7453 {
    static long[] X;
    static long[] Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        /*      입력 처리   */
        // index
        int i, j;

        int n =Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for(i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        /*      로직      */
        // 답
        long result = 0;
        // 우선 위에 써놓은 대로 배열을 두 개 두 개 합침.
        X = new long[n*n];
        Y = new long[n*n];

        int cur = 0;
        for(i = 0 ; i < n ; i++){
            for( j = 0 ; j < n ; j++){
                X[cur+i+j] = (long)A[i]+B[j];
                Y[cur+i+j] = (long)C[i]+D[j];
            }
            cur+=(n-1);
        }

        // 그다음 소팅
        Arrays.sort(X);
        Arrays.sort(Y);

        // 결과 저장
        long lower, upper;
        // 그다음에 X원소 하나마다 Y에서 반대값을 찾는 이분탐색 수행
        for(i = 0; i < n*n; i++){
           long target = -X[i];
           upper = (long)find_upper(target);
           lower = (long)find_lower(target);
           result += (upper-lower);
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
    static int find_upper(long target){
        int lower = 0 ;
        int upper = Y.length -1;
        while (lower <= upper){
            int mid = (lower+upper)/2;
            if(Y[mid] <= target)
                lower = mid+1;
            else upper = mid-1;
        }
        return lower;
    }
    static int find_lower(long target){
        int lower = 0 ;
        int upper = Y.length -1;
        while (lower <= upper){
            int mid = (lower+upper)/2;
            if(Y[mid] >= target)
                upper = mid-1;
            else lower = mid+1;
        }
        return lower;
    }
}
