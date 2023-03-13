package Bronze;

import java.io.*;

public class B2_9243 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb  =new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String ans = br.readLine();
        if( n % 2 == 1){
            for(int i = 0 ; i < str.length() ; i++){
                if(str.charAt(i) == '0')
                    sb.append("1");
                else sb.append("0");
            }
        }
        else sb.append(str);

        if(sb.toString().equals(ans))
            bw.write("Deletion succeeded");
        else bw.write("Deletion failed");
        bw.flush();
    }
}
