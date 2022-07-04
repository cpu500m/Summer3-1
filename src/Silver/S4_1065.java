package Silver;

import java.io.*;

public class S4_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(countN(Integer.parseInt(br.readLine()))));
        bw.flush();

    }
    public static int countN(int n){
        String st;
        int count = 0;
        int diff =0;
        boolean flag = false;
        for(int i = 1; i < n+1; i++){
            st = String.valueOf(i);
            if(st.length() >1){
                diff = Character.getNumericValue(st.charAt(1))- Character.getNumericValue(st.charAt(0));
            }
            else {
                count++;
                continue;
            }
            for(int j = 2 ; j < st.length() ; j++){
                if((Character.getNumericValue(st.charAt(j))- Character.getNumericValue(st.charAt(j-1))) != diff) {
                    flag = true;
                    break;
                }
            }
            if(!flag)
                count++;
            flag = false;
        }
        return count;
    }
}
