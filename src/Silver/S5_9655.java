// 따져보니 3이하는 sk승
// 홀 sk , 짝 cy승
package Silver;

import java.io.*;

public class S5_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if(n <=3 ) bw.write("SK");
        else if(n % 2 != 0) bw.write("SK");
        else bw.write("CY");
        bw.flush();
    }
}
