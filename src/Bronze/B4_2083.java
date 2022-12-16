package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int age, weight ;
        String name;
        name = st.nextToken();
        while(!name.equals("#")){
            sb.append(name+" ");
            age = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            if(age > 17 || weight >= 80)
                sb.append("Senior\n");
            else
                sb.append("Junior\n");
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
