package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S2_12891
 * @date : 25. 5. 2.
 */
public class S2_12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        int[] cnt = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt.length; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        Map<Character, Integer> indexMap = new HashMap<>();
        indexMap.put('A',0);
        indexMap.put('C',1);
        indexMap.put('G',2);
        indexMap.put('T',3);

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        int[] curCnt = new int[4];
        for (int i = 0; i < p; i++) {
            Integer charIdx = indexMap.get(str.charAt(i));
            if(charIdx != null){
               curCnt[charIdx]++;
            }
        }

        boolean isPossible = true;
        for (int i = 0; i < 4; i++) {
            if(curCnt[i] < cnt[i]) isPossible = false;
        }

        if(isPossible) answer++;

        for (int i = p; i < str.length(); i++) {
            Integer beforeIdx = indexMap.get(str.charAt(i - p));
            if(beforeIdx != null){
                curCnt[beforeIdx]--;
            }

            Integer afterIdx = indexMap.get(str.charAt(i));
            if(afterIdx != null){
                curCnt[afterIdx]++;
            }

            isPossible = true;
            for (int j = 0; j < 4; j++) {
                if(curCnt[j] < cnt[j]) isPossible = false;
            }

            if(isPossible) answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
