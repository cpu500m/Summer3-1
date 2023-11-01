package Silver;

import java.io.*;
import java.util.*;

public class S5_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<String, Boolean> map = new HashMap<>();

        logic(br, n, map);

        List<String> keySet = new ArrayList(map.keySet());

        sortList(keySet);

        for (String s : keySet) {
            bw.write(s+"\n");
        }

        bw.flush();
    }

    private static void sortList(List<String> keySet) {
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
    }

    private static void logic(BufferedReader br, int n, Map<String, Boolean> map) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            boolean cond = st.nextToken().equals("enter") ? true : false;
            if(cond)
                map.put(name, true);
            else map.remove(name);
        }
    }
}
