package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_20917 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            /* 입력 처리 */
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int[] pos = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pos[i] = Integer.parseInt(st.nextToken());
            }

            // 이분 탐색을 위해 오름차순 정렬
            Arrays.sort(pos);
            int[] dist = new int[n-1];
            for (int i = 0; i < n - 1; i++) {
                dist[i] = pos[i+1] - pos[i];
            }
            int result = parametricSearch(dist, s);
            sb.append(result);
            if(tc != TC-1)
                sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static int parametricSearch(int[] distance, int s){
        int left = 0;
        int right = 1_000_000_000;
        int optValue = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int cumSum = 0;
            int count = 1;
            for (int i = 0; i < distance.length; i++) {
                if(cumSum + distance[i] >= mid){
                    cumSum = 0;
                    count++;
                }else{
                    cumSum += distance[i];
                }
            }
            if(count >= s){
                optValue= Math.max(optValue, mid);
                left = mid+1;
            } else{
                right = mid-1;
            }
        }
        return optValue;
    }
}
