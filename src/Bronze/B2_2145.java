package Bronze;

import java.io.*;

public class B2_2145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int temp;
        while(str.compareTo("0") != 0){
            while(str.length() > 1){
                temp = 0;
                for(int i = 0; i < str.length() ;i++){
                    temp += Character.getNumericValue(str.charAt(i));
                }
                str = String.valueOf(temp);
            }
            sb.append(str+"\n");
            str = br.readLine();
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
