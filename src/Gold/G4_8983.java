package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_8983
 * @date : 2024-09-03
 */
public class G4_8983 {

    static class Position {

        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        /* 입력 처리 */
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] gunPositions = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            gunPositions[i] = Integer.parseInt(st.nextToken());
        }

        Position[] positions = new Position[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            positions[i] = new Position(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        /* 로직 */
        // 동물을 기준으로 볼 것임. 사대를 이분 탐색하기위해 오름차순 정렬
        Arrays.sort(gunPositions);

        // 이분 탐색
        int result = 0;
        for (Position p : positions) {
            int curX = p.x;
            int curY = p.y;

            int nearestGun = binarySearch(gunPositions, p, l);

            if(Math.abs(nearestGun - curX) <= l - curY){
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static int binarySearch(int[] gunPositions, Position p, int l) {
        int left = 0;
        int right = gunPositions.length;

        if(gunPositions.length == 1) return gunPositions[0];

        while (left != right) {
            int mid = left + (right - left) / 2;
            if (gunPositions[mid] < p.x) {
                left = mid + 1;
            } else { // 사대 위치가 오른쪽이라면 구간을 왼쪽으로 옮겨야함
                right = mid;
            }
        }

        if (right -1 < 0) {
            return gunPositions[right];
        }
        if(right == gunPositions.length){
            return gunPositions[right - 1];
        }

        return Math.abs(gunPositions[right] - p.x) > Math.abs(gunPositions[right - 1] - p.x)
                ? gunPositions[right - 1] : gunPositions[right];
    }
}
