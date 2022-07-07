package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int loop_count = Integer.parseInt(br.readLine());
        int H ,W , n;
        int room =0, floor=0;
        StringTokenizer st;
        for(int i =0 ; i <loop_count ; i++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            floor = (n % H) == 0 ? H : (n % H);
            room =  (n % H) == 0 ?  (n/H): ((n/H)+1);
            sb.append(floor);
            if(room < 10)
                sb.append("0"+room);
            else
                sb.append(room);
            bw.write(sb.toString()+"\n");
            sb.setLength(0);
        }
        bw.flush();
    }
}
