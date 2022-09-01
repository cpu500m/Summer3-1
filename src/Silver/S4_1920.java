package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1920 {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++)
            sb.append(binary_search(Integer.parseInt(st.nextToken()), 0 , N-1)+"\n");
        bw.write(sb.toString());
        bw.flush();
    }
    private static int binary_search(int n, int start , int end){
        int mid = (start+end)/2;
        if( start > end)
            return 0;
        if(arr[mid] == n)
            return 1;
        else if(arr[mid] > n)
            return binary_search(n, start, mid-1);
        else
            return binary_search(n,mid+1, end);
    }
}
