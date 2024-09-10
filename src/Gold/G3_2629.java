package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G3_2629
 * @date : 2024-09-10
 */
public class G3_2629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리 */
        int weightCount = Integer.parseInt(br.readLine());
        int[] weights = new int[weightCount];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weightCount; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int beadCount = Integer.parseInt(br.readLine());
        int[] beads = new int[beadCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < beadCount; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }

        // 가능한 무게 집합
        Map<Integer,Boolean> possibleMap = new HashMap<>();
        possibleMap.put(0, true);
        for (int i = 0; i < weightCount; i++) {
            Set<Integer> keySet = new HashSet<>(possibleMap.keySet());
            for (Integer curWeight : keySet) {
                possibleMap.put(curWeight + weights[i], true);
                if(curWeight > weights[i]) {
                    possibleMap.put(curWeight - weights[i] , true);
                }else{
                    possibleMap.put(weights[i] - curWeight, true);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < beadCount; i++) {
            if(possibleMap.get(beads[i]) != null) sb.append("Y ");
            else sb.append("N ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
