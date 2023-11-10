package Silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class S4_25192 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Boolean> map= new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                map = new HashMap<>();
                continue;
            }

            if(map.containsKey(str)) continue;
            else{
                map.put(str, true);
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
}
