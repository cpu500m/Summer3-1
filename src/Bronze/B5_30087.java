package Bronze;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B5_30087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        init(map);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(map.get(br.readLine())+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void init(Map<String, String> map) {
        map.put("Algorithm", "204");
        map.put("DataAnalysis", "207");
        map.put("ArtificialIntelligence", "302");
        map.put("CyberSecurity", "B101");
        map.put("Network", "303");
        map.put("Startup", "501");
        map.put("TestStrategy", "105");
    }
}
