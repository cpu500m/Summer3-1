// n이 최대 200이라 O(n^3)짜리 알고리즘 만들어도 충분해서 걍 만드는걸로.
// 약간 그리디 느낌으로 현재
// 자기위치와 가장 먼 애를 선택해서 걔를 자기자리 찾게 하면서
// 모든 애들이 자기자리 찾았을 때 그때 옮긴횟수 출력.
// 근데 해보니깐 이건 그리디로 하면 최적이 안되네?
// DP로 할걸 아 후회된다
// 그냥 최장증가부분수열 찾고 나머지만 정렬해주면 되겠구나.. ㅎㅎ;

package Gold;

import java.io.*;
import java.util.Arrays;

public class G4_2631 {
    static int lis_length = 1;
    static int[] line;
    static int[] LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index
        int i;
        /*      입력  처리  */
        int N = Integer.parseInt(br.readLine());
        line = new int[N];
        LIS = new int[N+1];
        for (i = 0; i < N; i++)
            line[i] = Integer.parseInt(br.readLine());

        /*      로직      */
        // 우선 , LIS 내부를 큰값으로 초기화.
        Arrays.fill(LIS, Integer.MAX_VALUE);
        for(i = 0 ; i <N ; i++){
            if(LIS[lis_length -1] < line[i])
                LIS[lis_length++] = line[i];
            else get_lis(line[i]);
        }
        bw.write(String.valueOf(N-lis_length));
        bw.flush();
    }

    static void get_lis(int value){
        int lower = 0;
        int upper = lis_length;
        int mid;
        while(lower < upper){
            mid = (lower+upper)/2;
            if(LIS[mid] < value)
                lower = mid+1;
            else upper = mid;
        }
        LIS[lower] = value;
    }
}
