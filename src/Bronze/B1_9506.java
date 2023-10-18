package Bronze;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B1_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n != -1) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i <= n / 2; i++) {
                if( n % i != 0) continue;
                list.add(i);
                sum += i;
            }
            if(sum == n){
                sb.append(n +" = ");
                for (int i = 0; i < list.size(); i++) {
                    sb.append(list.get(i));
                    if(i != list.size()-1)
                        sb.append(" + ");
                }
                sb.append("\n");
            } else sb.append(n + " is NOT perfect.\n");
            n = Integer.parseInt(br.readLine());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
