package Bronze;

import java.io.*;

public class B3_2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int n;
        int sum =0;
        int min_value = Integer.MAX_VALUE;
        for(int i = 0 ; i < 7; i++){
            n = Integer.parseInt(br.readLine());
            if( n %2 ==1) {
                sum += n;
                if(min_value > n)
                    min_value = n;
            }
        }
        if( sum ==0)
            bw.write("-1");
        else
            bw.write(String.valueOf(sum)+"\n"+String.valueOf(min_value));
        bw.flush();
    }
}
