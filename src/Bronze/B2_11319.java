package Bronze;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B2_11319 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        map.put('A', 1);
        map.put('E', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('U', 1);
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            int cnt1 = 0 , cnt2=0;
            for(int j = 0 ; j < str.length() ; j++){
                if(map.containsKey(str.charAt(j)))
                    cnt2++;
                else if(str.charAt(j) != ' ')cnt1++;
            }
            sb.append(cnt1+" "+cnt2+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
