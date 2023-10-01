// 아 이거 그
// 예를들어
// 100011 , 1100 , 11100 , 100001 머 요딴식으로 K가3 인데 여러개가 있을 수 있어 그게 중첩될 수 있단거지
// 내일 풀자
// 리스트에 담아서 루프 돌면서 20번 갱신하면될듯

package Gold;

import java.io.*;
import java.util.*;

public class G3_30015 {

    public static final int MAX_POW = 20;

    static class Temp{
        int originScore;
        boolean[] check;
        Temp(int os) {
            originScore = os;
            check = new boolean[MAX_POW + 1];
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
        // 각 학생 별 최대 pow 자릿 수 및 boolean 배열 갱신 O(N)
        int[] cnt = new int[MAX_POW+1];
        getCnt(n, temps, cnt);

        // max_pow를 구한다.O(1)
        int maxPow = getMax(k, cnt);

        // 시작 리스트를 갱신한다. O(N)
        List<Temp> list = listInit(n, temps, maxPow);
        // 루프를 돌며 리스트 내용을 갱신한다 O(N)
        list = updateList(k, maxPow, list);

        // 리스트 내 값들을 이용하여 결괏값을 구한다 O(1)
        int result = getResult(k,list);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void getCnt(int n, Temp[] temps, int[] cnt) {
        for (int i = 0; i < n; i++) {
            int curCnt = 20;
            for (int j = 1 << MAX_POW; j > 0; j >>= 1) {
                if( (j & temps[i].originScore) > 0) {
                    cnt[curCnt]++;
                    temps[i].check[curCnt] =true;
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

    private static List listInit(int n, Temp[] temps, int maxPow) {
        List<Temp> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(temps[i].check[maxPow])
                list.add(temps[i]);
        }
        return list;
    }

    private static List<Temp> updateList(int k, int maxPow, List<Temp> list) {
        for (int i = maxPow -1; i >= 0; i--) {
            List<Temp> temp_list = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                Temp cur = list.get(j);
                if (cur.check[i])
                    temp_list.add(cur);
            }
            if(temp_list.size() >= k)
                list = temp_list;
        }
        return list;
    }

    private static int getResult(int k, List<Temp> list) {
        int result = Integer.MAX_VALUE;
        if(list.size() < k)
            return 0;
        for (int i = 0; i < k; i++) {
            result &= list.get(i).originScore;
        }
        return result;
    }

}
