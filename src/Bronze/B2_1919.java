package Bronze;

import java.io.*;

public class B2_1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine();
        String str2 = br.readLine();
        boolean[] check1 = new boolean[str1.length()];
        boolean[] check2 = new boolean[str2.length()];
        int cnt=0;
        for(int i = 0; i < str1.length(); i++){
            for(int j = 0; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    if(!check2[j]){
                        check1[i]= true;
                        check2[j] = true;
                        break;
                    }
                }
            }
        }
        for(int i = 0; i <str2.length();i++)
            if(!check2[i])
                cnt++;

        for(int i = 0; i <str1.length();i++)
            if(!check1[i])
                cnt++;

        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
