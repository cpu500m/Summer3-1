package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_15661
 * @date : 2024-09-23
 */
public class G5_15661 {

    private static int result = Integer.MAX_VALUE;
    private static int[][] stat;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리 */
        n = Integer.parseInt(br.readLine());
        stat = new int[n][n];
        // 능력치 총 합
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start = 0;
        int teamScore = 0;
        int curIndex = n-1;
        backTracking(start,teamScore,curIndex);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void backTracking(int cur,int teamScore,int curIndex){
        int theOtherTeamScore = 0;
        for(int i=n-1 ; i>=0 ;i--){
            if((cur & 1<<i) == 0){
                for (int j = i-1; j >=0 ; j--) {
                    if((cur & 1<<j) == 0){
                        theOtherTeamScore += (stat[i][j] + stat[j][i]);
                    }
                }
            }
        }
        int diff = Math.abs((theOtherTeamScore - teamScore));
        if(diff < result){
            result = diff;
        }

        for(int i = curIndex;i >= 0;i--){
            cur ^= 1<<i;
            int curScore1 = teamScore;
            for (int j = n-1; j > curIndex; j--) {
                if((cur & 1<<j) != 0){
                    curScore1 += (stat[i][j] + stat[j][i]);
                }
            }
            backTracking(cur,curScore1,i-1);
            cur ^= 1<<i;
        }
    }
}
