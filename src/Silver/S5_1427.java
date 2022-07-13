package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class S5_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();
        Integer[] value = new Integer[N.length()];
        for(int i = 0 ; i <N.length(); i++) {
            value[i] = Character.getNumericValue(N.charAt(i));
        }
        Arrays.sort(value, Collections.reverseOrder());
        for(int i = 0 ; i < value.length;i++)
            sb.append(value[i]);
        bw.write(sb.toString());
        bw.flush();
    }
}
