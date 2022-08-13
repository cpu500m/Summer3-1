package Silver;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class S4_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] distance = new int[N-1];
        int[] city = new int[N];
        BigInteger cur_cost = new BigInteger("0");
        BigInteger val;
        String str1, str2;
        int best = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N-1 ; i++)
            distance[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            city[i] = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N-1 ; i++){
            if(best > city[i])
                best = city[i];
            str1 = String.valueOf(best);
            str2 = String.valueOf(distance[i]);
            val = new BigInteger(String.valueOf(new BigInteger(str1).multiply(new BigInteger(str2))));
            cur_cost = cur_cost.add(new BigInteger(val.toString()));
        }
        bw.write(cur_cost.toString());
        bw.flush();
    }
}
