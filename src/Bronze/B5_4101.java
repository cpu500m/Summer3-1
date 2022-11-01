package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B5_4101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        while(a != 0 && b!= 0){
            if(a > b)
                sb.append("Yes\n");
            else
                sb.append("No\n");
            st = new StringTokenizer(br.readLine());
             a = Integer.parseInt(st.nextToken());
             b = Integer.parseInt(st.nextToken());

        }
        bw.write(sb.toString());
        bw.flush();
    }
}
