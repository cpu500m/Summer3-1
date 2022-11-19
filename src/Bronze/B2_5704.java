package Bronze;

import java.io.*;

public class B2_5704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        boolean flag;
        StringBuilder sb = new StringBuilder();
        String comp = "abcdefghijklmnopqrstuvwxyz";
        boolean[] check = new boolean[comp.length()];
        while( !str.equals("*")){
            flag = false;
            for(int i = 0 ; i < comp.length() ; i++){
                check[i] = str.contains(String.valueOf(comp.charAt(i)));
            }
            for(int j = 0 ; j < check.length ; j++){
                if(!check[j]) {
                    sb.append("N\n");
                    flag = true;
                    break;
                }
            }
            if(!flag)
                sb.append("Y\n");
            for(int j = 0 ; j < check.length ; j++)
                check[j] = false;
            str = br.readLine();
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
