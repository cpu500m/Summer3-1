package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S5_1402
 * @date : 2024-11-08
 */
// A * (1) 되니깐 큰거 다되고
// A * (-1) * 1 * -1 도 되니깐 작은거도 다되네
public class S5_1402 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < TC ;tc++){
            br.readLine();
            sb.append("yes\n");
        }
        bw.write(sb.toString());
    }
}