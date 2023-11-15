package Bronze;

import java.io.*;

public class B3_30642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String name = br.readLine();
        int cur = Integer.parseInt(br.readLine());
        if(name.charAt(0)== 'a'){
            if (cur % 2 != 0) bw.write(String.valueOf(cur));
            else{
                if(cur+1 <= n) bw.write(String.valueOf(cur + 1));
                else bw.write(String.valueOf(cur-1));
            }
        }
        else{
            if(cur %2 == 0) bw.write(String.valueOf(cur));
            else{
                if(cur+1 <= n) bw.write(String.valueOf(cur + 1));
                else bw.write(String.valueOf(cur-1));
            }
        }
        bw.flush();
    }
}
