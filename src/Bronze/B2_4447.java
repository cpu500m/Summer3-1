package Bronze;

import java.io.*;

public class B2_4447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str , str_cp;
        StringBuilder sb = new StringBuilder();
        int g_count , b_count;
        for(int i = 0 ; i < n ; i++){
            str = br.readLine();
            g_count = 0;
            b_count = 0;
            str_cp = str.toLowerCase();
            for(int j = 0 ; j < str_cp.length(); j++){
                if( str_cp.charAt(j) == 'g')
                    g_count++;
                else if(str_cp.charAt(j) == 'b')
                    b_count++;
            }
            if (g_count > b_count)
                sb.append(str+" is GOOD\n");
            else if(g_count < b_count)
                sb.append(str+" is A BADDY\n");
            else
                sb.append(str+" is NEUTRAL\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
