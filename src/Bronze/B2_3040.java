package Bronze;

import java.io.*;

public class B2_3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        final int SIZE = 9;
        int[] arr = new int[SIZE];
        int sum = 0;
        for(int i = 0 ; i < SIZE ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        sum -=100;
        for(int i = 0 ; i < SIZE-1 ; i++) {
            for(int j = i+1; j <SIZE ;j++){
                if(arr[i]+arr[j] == sum) {
                    for(int k =0 ; k <SIZE ; k++){
                        if(k != i && k!= j)
                            sb.append(arr[k]+"\n");
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
