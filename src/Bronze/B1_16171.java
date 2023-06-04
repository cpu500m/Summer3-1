package Bronze;

import java.io.*;

public class B1_16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String sub_str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0 ; i <str.length() ; i++){
            if('0' <= str.charAt(i) && str.charAt(i) <= '9')
                continue;
            sb.append(str.charAt(i));
        }
        str = sb.toString();
        if(str.contains(sub_str))
            bw.write("1");
        else bw.write("0");
        bw.flush();
    }
}
