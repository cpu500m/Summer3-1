package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 5 ; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        while(true){
            boolean flag= false;
            for(int i = 0 ; i < 4 ; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    int t = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = t;
                    sb.append(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]+" "+arr[4]+"\n");
                }
            }
            if(flag) continue;
            break;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
