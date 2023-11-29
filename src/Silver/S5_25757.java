package Silver;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S5_25757 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        int p;
        if( c == 'Y') p =1;
        else if(c == 'F') p=2;
        else p = 3;

        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), true);
        }
        bw.write(String.valueOf(map.size()/p));
        bw.flush();
    }
}
