package Bronze;

import java.io.*;

public class B1_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder result = new StringBuilder();
        while (!sb.toString().equals("0")) {
            if(compare(sb)) result.append("yes\n");
            else result.append("no\n");
            sb.setLength(0);
            sb.append(br.readLine());
        }
        bw.write(result.toString());
        bw.flush();
    }

    private static boolean compare(StringBuilder sb) {
        return sb.toString().equals(sb.reverse().toString());
    }
}
