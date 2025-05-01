package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S1_6236
 * @date : 25. 5. 1.
 */
public class S1_6236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Integer.parseInt(br.readLine());
        }

        int l = 1;
        int r = 1_000_000_000;

        while(l < r){
            int mid = l + (r - l)/2;
            if(logic(mid,costs,m)) r = mid;
            else l = mid+1;
        }

        bw.write(String.valueOf(l));
        bw.flush();
    }

    public static boolean logic(int k, int[] costs, int m){

        int availableMoney = 0;
        int curIdx = 0;
        int cnt = 0;

        while(curIdx < costs.length){
            if(cnt == m) return false;

            if(availableMoney + costs[curIdx] <= k){
                availableMoney += costs[curIdx];
                curIdx++;
            } else{
                availableMoney = 0;
                cnt++;
            }
        }
        return true;
    }
}
