package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_3058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int sum, min, cur;
        StringTokenizer st;
        StringBuilder sb =new StringBuilder();
        for(int i =0; i< count ; i++){
            st = new StringTokenizer(br.readLine());
            sum = 0;
            min = 101;
            while (st.hasMoreElements()){
                cur = Integer.parseInt(st.nextToken());
                if( cur %2 == 0){
                    sum+=cur;
                    if(min > cur)
                        min = cur;
                }
            }
            sb.append(sum+ " "+min+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
