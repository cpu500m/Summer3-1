// 일단 가장먼저 생각나는 방법은
// 공유기 거리 1부터 늘려나가면서 최댓값까지 하는건데
// 이건 집좌표 범위가 10억까지이므로 무조건 시간초과임. ( 10억 * 집개수만큼 루프를 돌테니까)
// 그러면 그냥 공유기거리를 들어온 집 좌표 최댓값 + 0 의 중점으로 잡은다음에
// 이분 탐색 하면 될듯?

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2110 {
    private static int[] house;
    private static long max_length;
    private static int N, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];
        max_length = Integer.MIN_VALUE;
        int max_val = Integer.MIN_VALUE;
        for(int i = 0; i < N ; i++) {
            house[i]= Integer.parseInt(br.readLine());
            if(max_val < house[i])
                max_val = house[i];
        }
        Arrays.sort(house);
        binary_search(0 , max_val);
        bw.write(String.valueOf(max_length));
        bw.flush();
    }
    private static void binary_search(long start , long end){
        if( start > end)
            return ;
        long mid = (start+end)/2;
        long cnt = 1;
        int cur_house = house[0];
        for(int i = 1; i < N ; i++){
            if(house[i] - cur_house >= mid){
                cnt++;
                cur_house = house[i];
                if(cnt >= C)
                    break;
            }
        }
        if(cnt >= C ) {
            max_length = mid;
            binary_search(mid + 1, end);
        }
        else if(cnt < C)
            binary_search(start, mid-1);
    }
}
