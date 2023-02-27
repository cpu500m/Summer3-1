package Bronze;

import java.io.*;

public class B2_1731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr =new int[N];
        for(int i = 0 ; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        if(arr[2]-arr[1] == arr[1]-arr[0])
            bw.write(String.valueOf(arr[N-1]+(arr[2]-arr[1])));
        else
            bw.write(String.valueOf(arr[N-1]*(arr[2]/arr[1])));
        bw.flush();
    }
}
