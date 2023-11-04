package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_30395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int optVal = 0;

        processInput(br, n, arr);

        optVal = logic(n, arr, optVal);

        bw.write(String.valueOf(optVal));
        bw.flush();
    }

    private static int logic(int n, int[] arr, int optVal) {
        for (int i = 0; i < n; i++) {
            int cur = 0;
            int check = -2;
            for (int j = i; j < n; j++) {
                if(arr[j] != 0) cur++;
                else{
                    if(j >= check+2){
                        check = j;
                        continue;
                    } else cur = 0;
                }

                if(optVal < cur) optVal = cur;
            }
        }
        return optVal;
    }

    private static void processInput(BufferedReader br, int n, int[] arr) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
