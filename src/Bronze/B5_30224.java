package Bronze;

import java.io.*;

public class B5_30224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int res = 0;
        if(input.contains("7")) res +=2;
        if(Integer.parseInt(input) % 7 ==0) res +=1;
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
