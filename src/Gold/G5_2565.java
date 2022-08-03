// A 전봇대를 오름차순으로 정렬하고
// B 전봇대에 연결된 줄이 교차되는경우는 1번줄 < 2번줄인 경우니까
// 무조건 B전봇대에 연결된 줄은 오름차순으로 돼있어야 교차되지 않는거니까
// A를 기준으로 정렬하고 B에서 가장 긴 오름차순 길이 구해서
// 전체 전선수에서 뺴면 될거같음.
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G5_2565 {
    private static int[][] wires;
    private static int[] LIS;
    private static int LIS_length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        wires = new int[N+1][2];
        LIS = new int[N+1];
        Arrays.fill(LIS,Integer.MAX_VALUE);
        LIS_length = 1;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i =1 ; i <= N ; i++){
            if( wires[i][1] > LIS[LIS_length])
                LIS[++LIS_length] = wires[i][1];
            else
                getLIS(i);
        }
        bw.write(String.valueOf(N-LIS_length));
        bw.flush();
    }
    private static void getLIS(int N) {
        int lower_bound = 1;
        int upper_bound = LIS_length;
        while(lower_bound < upper_bound){
            int mid = (lower_bound+upper_bound)/2;
            if(LIS[mid] < wires[N][1]){
                lower_bound = mid+1;
            }
            else
                upper_bound = mid;
        }
        LIS[lower_bound] = wires[N][1];
    }
}
