package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S1_1850
 * @date : 25. 5. 1.
 */
public class S1_1850 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int lcd = euclidean(a, b);
        char[] result = new char[lcd];
        Arrays.fill(result, '1');
        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static int euclidean(long a , long b){
        if( b == 0){
            return (int)a;
        }
        return euclidean(b ,a %b);
    }
}
