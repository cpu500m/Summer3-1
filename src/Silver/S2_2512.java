package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2512 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            total += cur;
            arr[i] = cur;
        }
        Arrays.sort(arr);

        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = arr[i] + sum[i-1];
        }

        int[] searchArr = new int[n];
        searchArr[0] = arr[0]*n;
        for (int i = 1; i < n; i++) {
            searchArr[i] = arr[i]*(n-i) + sum[i-1];
        }

        int budget = Integer.parseInt(br.readLine());


        // 이분 탐색 때려
        int idx = binSearch(budget, searchArr);
        int res = 0;
        if(idx == -1)
            res = budget/n;
        else if(idx == arr.length-1)
            res = arr[idx];
        else{
            budget -= searchArr[idx];
            res = arr[idx];
            res += (budget/(arr.length-(idx+1)));
        }


        bw.write(String.valueOf(res));
        bw.flush();
    }
    static int binSearch(int budget, int[] arr){
        int l = 0;
        int len = arr.length;
        int r = len;
        while (l != r){
            int mid = l + (r-l)/2;
            if(arr[mid] <= budget) l = mid+1;
            else r = mid;
        }
        return l-1;
    }
}
