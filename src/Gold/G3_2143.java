// 흠..
// 포인터 각 배열에 두개씩 놓은다음에 구간합을 계산해서
// 타겟 기준으로 큰지 작은지를 조사해서 해야겠다는 생각이 대충 들긴하는데..
// 일단 좀 생각을 해보면
// 일단 A배열의 스타트 지점은 고징셔켜 놓는다고 해보자. 그러니깐 총 999번 고정해야겠지
// 그리고 999번 루프 각각 안에서 A배열 끝 포인터는 맨 뒤에 위치시키고
// A배열 끝 포인터가 앞으로 한칸씩 이동하면서
package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G3_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*      입력  처리      */
        // index
        int i,j;

        int T = Integer.parseInt(br.readLine());
        int n =  Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < n; i++)
            A[i] =  Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < m ; i++)
            B[i] = Integer.parseInt(st.nextToken());

        /*    로직    */


    }
}
