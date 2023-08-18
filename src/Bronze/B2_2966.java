package Bronze;

import java.io.*;
import java.util.Arrays;

public class B2_2966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] adrian = {'A','B','C'};
        char[] bruno = {'B', 'A', 'B', 'C'};
        char[] goran = {'C', 'C', 'A', 'A', 'B', 'B'};
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Integer[] cnt = new Integer[3];
        Arrays.fill(cnt, 0);
        String[] names = {"Adrian", "Bruno", "Goran"};
        for (int i = 0; i < n; i++) {
            if(adrian[i % adrian.length] == str.charAt(i)) cnt[0]++;
            if(bruno[i % bruno.length] == str.charAt(i)) cnt[1]++;
            if(goran[i % goran.length] == str.charAt(i)) cnt[2]++;
        }
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < cnt.length; i++) {
            if(max <cnt[i]) max =cnt[i];
        }
        sb.append(max + "\n");
        for (int i = 0; i < cnt.length; i++) {
            if(max == cnt[i])
                sb.append(names[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
