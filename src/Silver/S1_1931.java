package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S1_1931 {
    private static final int START = 0;
    private static final int END = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];
        int cnt = 0;
        int cur_end = 0;
        for(int i = 0 ; i <N; i++){
            st= new StringTokenizer(br.readLine());
            meeting[i][START] = Integer.parseInt(st.nextToken());
            meeting[i][END] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[END] == o2 [END])
                    return o1[START]-o2[START];
                else
                    return o1[END] - o2[END];
            }
        });
//        for(int i = 0 ; i < N ; i++)
//            bw.write(meeting[i][0] +" "+ meeting[i][1]+"\n");
        for(int i = 0 ; i <N ; i++){
            if(meeting[i][END] != cur_end){
                if( cur_end <= meeting[i][START]) {
                    cnt++;
                    cur_end = meeting[i][END];
                }
                continue;
            }
            else if( meeting[i][START] == meeting[i][END]) {
                cnt++;
                continue;
            }
        }
//        for(int i = 0 ; i < cnt ; i++)
//            bw.write(possible_meeting[i][0] +" "+ possible_meeting[i][1]+"\n");
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
