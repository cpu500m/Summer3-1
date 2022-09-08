package Bronze;

import java.io.*;

public class B2_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        StringBuilder sb = new StringBuilder();
        int div;
        int a;

        div = 4;
        a = Character.getNumericValue(n.charAt(0));
        while(div > 0){
            if(a >= div) {
                sb.append("1");
                a -=div;
            }
            else {
                if(sb.length() == 0) {
                    div/=2;
                    continue;
                }
                sb.append("0");
            }
            div/=2;
        }
        for(int i = 1 ; i < n.length() ; i++){
            div = 4;
            a = Character.getNumericValue(n.charAt(i));
            while(div > 0){
                if(a >= div) {
                    sb.append("1");
                    a -=div;
                }
                else
                    sb.append("0");
                div/=2;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
