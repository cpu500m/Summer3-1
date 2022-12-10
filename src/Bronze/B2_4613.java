package Bronze;

import java.io.*;

public class B2_4613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int sum , i;
        StringBuilder sb = new StringBuilder();
        while(!str.equals("#")){
            sum = 0;
            for(i = 0 ; i < str.length(); i++){
                if(str.charAt(i) == ' ')
                    continue;
                else
                    sum+= (str.charAt(i) - 'A'+1)*(i+1);
            }
            sb.append(sum+"\n");
            str = br.readLine();
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
