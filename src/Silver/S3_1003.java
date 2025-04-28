package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S3_1003
 * @date : 2025-04-14
 */
public class S3_1003 {

    private static class Count{
        long zeroCount;
        long oneCount;

        public Count(long zeroCount, long oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }
    }

    private static final int MAX_N = 40;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());

        Count[] counts = new Count[MAX_N+1];
        counts[0] = new Count(1, 0);
        counts[1] = new Count(0, 1);
        for (int i = 2; i < counts.length; i++) {
            counts[i] = new Count(counts[i-2].zeroCount+counts[i-1].zeroCount,
                    counts[i-2].oneCount+counts[i-1].oneCount);
        }

        for (int tc = 0; tc < TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(counts[N].zeroCount +" "+ counts[N].oneCount+ "\n");
        }
        bw.flush();
    }
}
