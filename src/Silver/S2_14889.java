package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_14889 {
    private static int[][] S;
    private static int N;
    private static int min =Integer.MAX_VALUE;
    private static boolean[] include;
    private static int team1_score, team2_score;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N+1][N+1];
        include = new boolean[N+1];
        for(int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++)
                S[i][j] = Integer.parseInt(st.nextToken());
        }
        buildTeam(0, 1);
        bw.write(String.valueOf(min));
        bw.flush();
    }
    public static void buildTeam(int count, int start) throws IOException {
        if(count == N/2){
            team1_score = 0;
            team2_score = 0;
            for(int i = 1 ; i <= N-1 ; i++){
                for(int j = i+1; j <= N ; j++){
                    if( include[i] == true && include[j] == true)
                       team1_score += (S[i][j] + S[j][i]);
                    else if(include[i] == false && include[j] == false)
                        team2_score +=(S[i][j] + S[j][i]);
                }
            }
            min = Math.min(min, Math.abs(team1_score-team2_score));
            if(min == 0) {
                bw.write(String.valueOf(min));
                bw.flush();
                System.exit(0);
            }
            return;
        }
        for(int i = start; i <= N ; i++){
            if(promising(i)){
                include[i] = true;
                buildTeam(count+1, i+1);
                include[i] = false;
            }
        }
    }
    public static boolean promising(int count){
            if(include[count] == true)
                return false;
        return true;
    }
}
