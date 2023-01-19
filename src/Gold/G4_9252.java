package Gold;

import java.io.*;
import java.util.Arrays;

public class G4_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*      입력  처리      */
        // index
        int i,j;
        String str1= br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str2.length()+1][str1.length()+1];

        /*      로직      */
        // 우선 모든 칸 0으로 초기화.
        for(i = 0 ; i <= str2.length() ; i++)
            Arrays.fill(dp[i],0);

        // 흠.. 대각선에서 +1 하는게 맞는로직같네
        for(i = 1 ; i <= str2.length() ; i++){
            for( j = 1; j <= str1.length() ; j++){
                if(str1.charAt(j-1) == str2.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }

        int cur = dp[str2.length()][str1.length()];
        int cur_x = str2.length();
        int cur_y = str1.length();
        // 일단은.. 현재 행에서 가장 왼쪽 까지 이동해야함.
        while (cur !=0){
            while (dp[cur_x][cur_y-1] == cur)
                cur_y--;
            // 그다음에는 위로 올라가야됨.
            while (dp[cur_x-1][cur_y] == cur)
                cur_x--;
            sb.append(str2.charAt(cur_x-1));
            cur_y--;
            cur_x--;
            cur--;
        }
        bw.write(String.valueOf(dp[str2.length()][str1.length()]));
        if(sb.length() !=0)
            bw.write("\n"+sb.reverse().toString());
        bw.flush();
    }
}
