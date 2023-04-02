package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_14910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean check= false;
        int pre = -123456789;
        while (st.hasMoreElements()){
            int c = Integer.parseInt(st.nextToken());
            if(pre > c){
                check = true;
                break;
            }
            pre = c;
        }
        if(check) bw.write("Bad");
        else bw.write("Good");
        bw.flush();
    }
}
