// 그냥 N*N 배열 만들어서 하려다가
// 메모리 제한을 보니깐 4MB네?
// 이러면 그냥 N짜리 1차원 배열에다가 덮어쓰느 형식으로 가야겠음.

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index
        int i, j;
        /*      입력  처리      */
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] pre_min = new int[3];
        int[] pre_max = new int[3];
        int[] min = new int[3];
        int[] max = new int[3];
        int[] cur_map = new int[3];
        int temp;
        int result_max = Integer.MIN_VALUE , result_min =Integer.MAX_VALUE;

        /*  로직 */
        Arrays.fill(pre_min,0);
        Arrays.fill(pre_max,0);
        for(i = 0 ; i <N ;i++){
            st = new StringTokenizer(br.readLine());
            // 입력 처리하고
            for(j = 0 ; j < 3 ; j++)
                cur_map[j] = Integer.parseInt(st.nextToken());
            // 걍 얼마안되니깐 귀찮아서 이렇게함
            min[0] = cur_map[0] + Math.min(pre_min[0],pre_min[1]);
            max[0] = cur_map[0] + Math.max(pre_max[0],pre_max[1]);

            temp = Math.min(pre_min[0],pre_min[1]);
            temp = Math.min(temp,pre_min[2]);
            min[1] = cur_map[1] + temp;

            temp = Math.max(pre_max[0],pre_max[1]);
            temp = Math.max(temp,pre_max[2]);
            max[1] = cur_map[1] + temp;

            min[2] = cur_map[2] + Math.min(pre_min[1],pre_min[2]);
            max[2] = cur_map[2] + Math.max(pre_max[1],pre_max[2]);

            for( j = 0; j <3 ; j++) {
                pre_min[j] = min[j];
                pre_max[j] = max[j];
            }
        }
        for(i = 0 ; i < 3; i ++){
            if(result_max < max[i])
                result_max = max[i];
            if(result_min > min[i])
                result_min = min[i];
        }

        bw.write(String.valueOf(result_max)+" "+String.valueOf(result_min));
        bw.flush();
    }
}
