package Bronze;

import java.io.*;

public class B2_5919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int i , sum = 0, mean, result = 0;
        for( i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        mean = sum / n;
        for( i = 0 ; i < n ; i++){
            if(mean < arr[i])
                result += (arr[i] - mean);
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
