package Bronze;

import java.io.*;

public class B3_3004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int result=1 , cur =1;
        for(int i = 1; i <= N; i++){
            if( i % 2 == 1){
                result += cur;
            }
            else
                result+= ++cur;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
