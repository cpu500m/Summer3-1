package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S2_10819
 * @date : 25. 4. 28.
 */
public class S2_10819 {

    private static int answer = 0;
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        boolean[] isVisited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(isVisited,0,new LinkedList<>());

        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void backTracking(boolean[] isVisited, int sum ,List<Integer> curList){
        // N개 다 리스트에 넣었다면
        if(curList.size() == N){
            if(answer < sum){
                answer = sum;
            }
            return ;
        }

        for(int i = 0 ; i < N ; i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;

            boolean check = false;
            int addValue = 0;
            if(!curList.isEmpty()){
                addValue = Math.abs(curList.get(curList.size() - 1) - arr[i]);
                sum += addValue;
                check = true;
            }
            curList.add(arr[i]);

            backTracking(isVisited,sum,curList);

            if(check) sum -= addValue;
            isVisited[i] = false;
            curList.remove(curList.size()-1);
        }
    }
}
