package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int first =-1, second=-1;
        while( true){
            st=new StringTokenizer(br.readLine());
            first =  Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            if(first== 0 && second ==0)
                break;
            if(first % second == 0)
                sb.append("multiple\n");
            else if(second % first == 0)
                sb.append("factor\n");
            else
                sb.append("neither\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
