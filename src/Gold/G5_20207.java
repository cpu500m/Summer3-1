package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_20207
 * @date : 2024-10-16
 */
public class G5_20207 {
    private static final int DAY_COUNT = 365;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] height = new int[DAY_COUNT+1];

        /* 입력 처리 */
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            for (int j = S; j <= E; j++) {
                height[j]++;
            }
        }

        /* 로직 */
        int result = 0;
        boolean[] isVisited = new boolean[DAY_COUNT+1];
        for (int i = 1; i <= DAY_COUNT; i++) {
            if(isVisited[i]) continue;
            if(height[i]> 0){
                int curHeight = 0;
                int start = i;
                int end = 0;
                for (int j = start; j <= DAY_COUNT; j++) {
                    if(height[j] < 1) break;

                    isVisited[j] = true;
                    end = j;
                    if(curHeight < height[j]){
                        curHeight = height[j];
                    }
                }
                result += curHeight * (end-start+1);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
