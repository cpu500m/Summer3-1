package Silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class S4_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) {
                map.put(str, map.get(str)+1);
            } else map.put(str, 1);
        }
        Integer max = 0;
        String res = "";
        for (String key : map.keySet()) {
            int tmp = map.get(key);
            if (max < tmp) {
                max = tmp;
                res = key;
            } else if (max == tmp){
                if(key.compareTo(res) < 0)
                    res = key;
            }
        }
        bw.write(res);
        bw.flush();
    }
}
