package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S1_2343
 * @date : 25. 5. 1.
 */
public class S1_2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lectures = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }

        /* 로직 */
        // parametric search 하면 될듯
         int l = 1;
         int r = 1_000_000_001;

         while (l < r) {
             int mid = l + (r - l)/2;
             if(logic(mid, lectures, m)){
                  r = mid;
             } else{
                 l = mid+1;
             }
         }
         bw.write(String.valueOf(l));
         bw.flush();
    }

    public static boolean logic(int possibleTime, int[] lectures, int count) {

        int curTime = 0;
        int curCnt = 0;

        int curIdx = 0;
        while (curIdx < lectures.length) {
            if(curCnt == count) return false;
            int time = lectures[curIdx];
            if(curTime + time <= possibleTime){
                curTime += time;
                curIdx++;
            } else{
                curCnt++;
                curTime = 0;
            }
        }
        return true;
    }
}
