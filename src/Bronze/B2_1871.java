package Bronze;

import java.io.*;

public class B2_1871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String str;
        char next_char;
        int sum, front_mul, back_mul;
        for(int i = 0; i <N; i++){
            str = br.readLine();
            sum = 0;
            front_mul = 2;
            back_mul = 3;
            for(int j = 0 ; j < str.length() ; j++) {
                next_char = str.charAt(j);
                if(next_char == '-')
                    continue;
                if(front_mul < 0)
                    sum -= (int)Math.pow(10,back_mul--)*(next_char-'0');
                else
                   sum += (int)Math.pow(26, front_mul--)*(next_char-'A');
            }
            if(Math.abs(sum) <= 100)
                sb.append("nice\n");
            else
                sb.append("not nice\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
