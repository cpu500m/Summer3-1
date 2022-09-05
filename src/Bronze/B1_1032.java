package Bronze;

import java.io.*;

public class B1_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        StringBuilder sb = new StringBuilder();
        boolean[] check;
        for(int i = 0; i < N ; i++)
            str[i] = br.readLine();
        check = new boolean[str[0].length()];
        for(int i = 1 ; i < N; i++){
            for(int j = 0 ; j < str[i].length() ; j++){
                if(str[i-1].charAt(j) != str[i].charAt(j))
                    check[j] = true;
            }
        }
        for(int i = 0 ; i < str[0].length();i++){
            if(check[i])
                sb.append("?");
            else
                sb.append(str[0].charAt(i));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
