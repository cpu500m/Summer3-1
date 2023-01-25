// 시도했다 실패함 ㅎ.. . 괜히 시간투자헀다
// 일단 할거하고 나중에 시간되면 해보자..
package Diamond;

import java.io.*;
import java.util.Arrays;

public class D1_18438 {
    static class Pos{
        int str2_idx, str1_idx;
        Pos(int str2_idx , int str1_idx){
            this.str2_idx = str2_idx;
            this.str1_idx = str1_idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*      입력  처리      */
        // index
        int i,j;
        String str1= br.readLine();
        String str2 = br.readLine();
        // 메모리 제한이 있으므로 한 행에서 이전 기록을 가지고 갱신하도록 하자
        int[] dp = new int[str1.length()+1];
        int[] pre = new int[str1.length()+1];

        /*      로직      */
        // 우선 모든 칸 0으로 초기화.
        Arrays.fill(dp,0);
        Arrays.fill(pre,0);

        // 그리고.. 최대 7천이니깐.. 이렇게 해주자 일단 ㅇㅇ
        Pos[] pos = new Pos[7001];
        for(i = 0 ; i <= 7000; i++){
            pos[i] = new Pos(7001,7001);
        }
        // 각 행마다 갱신.
        for(i = 1 ; i <= str2.length() ; i++){
            for( j = 1; j <= str1.length() ; j++){
                if(str1.charAt(j-1) == str2.charAt(i-1))
                    dp[j] = pre[j-1]+1;
                else dp[j] = Math.max(dp[j-1] , pre[j]);
                // 여기서 이제 갱신을 해줘야함.
                if( pos[dp[j]].str1_idx > j){
                    pos[dp[j]].str1_idx = j;
                    pos[dp[j]].str2_idx = i;
                }
            }
            for(j = 1; j <=str1.length() ; j++){
                pre[j] = dp[j];
            }
        }

        int result = 0;
        // 최장 길이를 찾는다.
        for(i = 1 ; i <= str1.length() ; i++)
            if(result < dp[i])
                result = dp[i];

        // 그리고.. pos를 돌면서 문자열을 찾아줘야함 ㅇㅇ
        for(i = 1 ; i <= 7000; i++){
            // 여기까지 갱신이 안됐다면 그만
            if(pos[i].str1_idx == 7001)
                break;
            sb.append(str2.charAt(pos[i].str2_idx-1));
        }

        bw.write(String.valueOf(result)+"\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
