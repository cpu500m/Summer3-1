package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_5063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int i;
        int no_ad, ad;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(i = 0 ; i< n ; i++){
            st = new StringTokenizer(br.readLine());
            no_ad = Integer.parseInt(st.nextToken());
            ad = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
            if(ad > no_ad)
                sb.append("advertise\n");
            else if(ad == no_ad)
                sb.append("does not matter\n");
            else
                sb.append("do not advertise\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
