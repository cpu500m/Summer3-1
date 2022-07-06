package Silver;

import java.io.*;

public class S5_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        String str;
        int count = 0;
        boolean flag;
        for(int i =0 ; i <loop_count; i++){
            str = br.readLine();
            flag=false;
            for(int j = 0; j<str.length();j++){
                for(int k = 0 ; k <j-1; k++){
                    if(str.charAt(j) == str.charAt(k)){
                        for(int a = k+1 ; a < j; a++){
                            if(str.charAt(a) != str.charAt(j)) {
                                count++;
                                flag=true;
                                break;
                            }
                        }
                    }
                    if(flag)
                        break;
                }
                if(flag)
                    break;
            }
        }
        bw.write(String.valueOf(loop_count-count));
        bw.flush();
    }
}
