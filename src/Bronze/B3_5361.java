package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_5361 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double[] price = {350.34,230.90,190.55,125.30,180.90};
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        double total;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < n ; i++){
            total = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 5 ; j++){
                total += price[j]*(Integer.parseInt(st.nextToken()));
            }
            sb.append("$"+String.format("%.2f",total)+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
