package Bronze;

import java.io.*;

public class B3_3059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= TC ; ++tc){
            boolean[] check = new boolean[26];
            String str = br.readLine();
            int sum = 0;
            for(int i = 0 ; i < str.length() ; i++)
                check[str.charAt(i)-'A'] = true;
            for(int i = 0 ; i <26; i++)
                if(!check[i]) sum += 65 +i;
            sb.append(sum+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
