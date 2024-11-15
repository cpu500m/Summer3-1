package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S3_10158
 * @date : 2024-11-08
 */

public class S3_10158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        List<Info> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int x= Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        // 예시로 보면 나머지 1 : + 1
        // 2 : +2
        // 3: +3
        // 4: +2
        // 5 : +1
        // 6: +0
        //7 : -1
        int  top = t % h;
        int width = t % w;

    }
}
