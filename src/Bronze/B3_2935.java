package Bronze;

import java.io.*;

public class B3_2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        StringBuilder sb = new StringBuilder();
        char op = br.readLine().charAt(0);
        String b = br.readLine();
        String temp;
        if (a.length() > b.length()) {
            sb.append(a);
        } else{
            temp = a;
            a = b;
            b = temp;
            sb.append(a);
        }
        if( op == '*')
            for (int i = 1; i < b.length(); i++) {
                sb.append("0");
            }
        else{
            if(a.length() == b.length())
                sb.replace(0, 1, "2");
            else sb.replace((a.length()-1)  -b.length()+1, (a.length()-1) - b.length()+2, "1");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
