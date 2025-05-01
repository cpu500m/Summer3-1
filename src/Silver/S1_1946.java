package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S1_1946
 * @date : 25. 5. 1.
 */
public class S1_1946 {

    private static class Info{

        int documentRank;
        int interviewRank;

        Info(int documentRank, int interviewRank){
            this.documentRank = documentRank;
            this.interviewRank = interviewRank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            Info[] info = new Info[n];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                info[j] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(info, Comparator.comparingInt(o -> o.documentRank));

            int standard = 100001;
            int answer = 0;
            for(int j = 0; j < n; j++){
                if(info[j].interviewRank < standard){
                    standard = info[j].interviewRank;
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
