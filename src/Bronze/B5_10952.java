/* 2022-06-27*/
package Bronze;
import java.io.*;
import java.util.StringTokenizer;

public class B5_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String line;
        int a ,b;
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            a =Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if( a== 0 && b==0)
                break;
            bw.write((a+b)+"\n");
        }
        bw.flush();
    }
}
