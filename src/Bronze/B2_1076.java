package Bronze;

import java.io.*;

public class B2_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        long result = 0;
        Resistance[] resistance = Resistance.values();
        for(int i = 1 ; i >= 0 ; i--) {
            input = br.readLine();
            for (Resistance r : resistance) {
                if (input.equals(String.valueOf(r))){
                    result += r.ordinal()*(long)Math.pow(10,i);
                    break;
                }
            }
        }
        input = br.readLine();
        for (Resistance r : resistance) {
            if (input.equals(String.valueOf(r))){
                result *= (long)Math.pow(10,r.ordinal());
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
    enum Resistance {
        black , brown , red , orange , yellow , green , blue , violet , grey, white
    }
}
