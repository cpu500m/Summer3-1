package Bronze;

import java.io.*;

public class B3_5724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        long arr[] = new long[101];
        for(int i = 1; i <101; i++)
            arr[i] = (i*i)+arr[i-1];
        int next;
        while((next= Integer.parseInt(br.readLine())) != 0){
            sb.append(arr[next]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
