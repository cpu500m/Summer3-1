// 아 이거 그
// 예를들어
// 100011 , 1100 , 11100 , 100001 머 요딴식으로 K가3 인데 여러개가 있을 수 있어 그게 중첩될 수 있단거지
// 내일 풀자
// 리스트에 담아서 루프 돌면서 20번 갱신하면될듯
// TODO: 2023-09-30 마저 풀어라
package Gold;

import java.io.*;
import java.util.*;

public class G3_30015 {

    public static final int MAX_POW = 20;

    static class Temp{
        int originScore;

        Temp(int os) {
            originScore= os;
        }
    }
    public static void main(String[] args) throws IOException {
        /* process input */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Temp[] temps = new Temp[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temps[i] = new Temp(Integer.parseInt(st.nextToken()));
        }

        /* logic */
        int[] cnt = new int[MAX_POW+1];
        getCnt(n, temps, cnt);

        int maxPow = getMax(k, cnt);
        sortArr(temps);

        int result = getResult(k, temps , maxPow);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void getCnt(int n, Temp[] temps, int[] cnt) {
        for (int i = 0; i < n; i++) {
            int curCnt = 20;
            for (int j = 1 << MAX_POW; j > 0; j >>= 1) {
                if( (j & temps[i].originScore) > 0) {
                    cnt[curCnt]++;
                }
                curCnt--;
            }
        }
    }

    private static int getMax(int k, int[] cnt) {
        int maxPow = 0;
        for (int i = MAX_POW; i >= 0; i--) {
            if(cnt[i] >= k) {
                maxPow = i;
                break;
            }
        }
        return maxPow;
    }

    private static void sortArr(Temp[] temps) {
        Arrays.sort(temps, new Comparator<Temp>() {
            @Override
            public int compare(Temp o1, Temp o2) {
                return o2.originScore - o1.originScore;
            }
        });
    }

    private static int getResult(int k, Temp[] temps , int maxPow) {
        int result = Integer.MAX_VALUE;
        int start = maxPow-1;

        for (int i = start; i >= 0; i--) {
            int cnt = 0;
            List<Integer> list = new ArrayList<>();
//            if((1<<start) &
        }
        return result;
    }

}
