package Bronze;

import java.io.*;

public class B3_17094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] cnt = new int[2];
        for(int i = 0 ; i < l ; i++){
            char c = str.charAt(i);
            if(c == '2') cnt[0]++;
            else cnt[1]++;
        }
        if(cnt[0] > cnt[1]) bw.write("2");
        else if(cnt[0] < cnt[1]) bw.write("e");
        else bw.write("yee");
        bw.flush();
    }
}
