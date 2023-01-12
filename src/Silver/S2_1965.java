// 흠.,. 주어진 예시인
// 1 6 2 5 7 3 6 으로 생각을 해보자.
// 일단 1-> 6 , 2->5->7 , 3-> 6
// 해서 6 7 6 세개의 박스만 남았을거아니야?
// 그러면 이제 6->7 해주는건데
// 그냥 현재 상자가 합쳐졌는지 아닌지 체크해두는 boolean 배열 하나 두고.
// 종료조건은.. 만약 진척이 없다면 종료를 시키는 식으로 하면 되지않을까?
// 어차피 시간제한도 널널하니깐 충분할듯 N도 최대 1000이고

// 아니 ㅋㅋ 문제가 그게 아니었네
// 그냥 가장 길이가긴 증가 부분 수열 찾는거였네


package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_1965 {
    static int LIS_length = 0;
    static int[] LIS;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index
        int i,j;

        /*      입력 처리       */
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] box = new int[N];
        LIS = new int[N];

        for( i = 0 ; i < N ; i++){
            box[i] = Integer.parseInt(st.nextToken());
        }

        /*      로직      */
        // 우선 , LIS 배열 내를 max값으로 채움
        Arrays.fill(LIS, Integer.MAX_VALUE);

        for(i = 0 ; i < N ; i++){
            if(box[i] > LIS[LIS_length])
                LIS[++LIS_length] = box[i];
            else
                get_lis(box[i]);
        }
        bw.write(String.valueOf(LIS_length+1));
        bw.flush();
    }
    static void get_lis(int cur_box){
        int lower = 0;
        int upper = LIS_length;
        int mid;
        while (lower < upper){
            mid = (lower+upper)/2;
            if(LIS[mid] < cur_box)
                lower = mid+1;
            else
                upper = mid;
        }
        LIS[lower] = cur_box;
    }
}
