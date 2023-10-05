package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_25206 {
    final static int LINE = 20;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        float sum = 0;
        float total = 0;
        StringTokenizer st;
        for (int i = 0; i < LINE; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double s = Double.parseDouble(st.nextToken());
            String g = st.nextToken();
            Double grade = decideScore(g);
            if (grade == null) continue;
            total += s;
            sum += (s*grade);
        }
        bw.write(String.valueOf(sum / total));
        bw.flush();
    }

    private static Double decideScore(String g) {
        double grade = 4.0;
        if (g.equals("P")) return null;
        else if(g.equals("F")){grade = 0;}
        else{
            grade -= (g.charAt(0)- 'A');
            char o = g.charAt(1);
            if(o =='+') grade+=0.5;
        }
        return grade;
    }
}
