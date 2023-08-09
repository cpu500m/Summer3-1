package Bronze;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B1_1672 {
    private final static int A = 0;
    private final static int G = 1;
    private final static int C = 2;
    private final static int T = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('A', 0);
        hashMap.put('G', 1);
        hashMap.put('C', 2);
        hashMap.put('T', 3);
        char[] result = {'A', 'G', 'C', 'T'};
        int[][] match_info = {{A,C,A,G},
                {C,G,T,A},
                {A,T,C,G},
                {G,A,G,T}};
        String seq = br.readLine();

        int result_idx = 0;
        if(n > 1) result_idx = match_info[hashMap.get(seq.charAt(n-1))][hashMap.get(seq.charAt(n-2))];
        for (int i = n-3; i >= 0; i--) {
            result_idx = match_info[result_idx][hashMap.get(seq.charAt(i))];
        }
        if(n<2)
            bw.write(seq);
        else
            bw.write(result[result_idx]);
        bw.flush();
    }
}
