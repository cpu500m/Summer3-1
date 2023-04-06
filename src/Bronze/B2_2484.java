package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cnt = new int[7];
            int max_cnt = 0;
            int max_v = 0;
            int d_cnt = 0;
            int prize = 0;
            for(int j = 0 ; j < 4 ; j++){
                int cur = Integer.parseInt(st.nextToken());
                cnt[cur]++;
                if(cnt[cur] == 2)
                    d_cnt++;
                if(max_cnt < cnt[cur]) {
                    max_cnt = cnt[cur];
                    max_v = cur;
                }
            }
            if(d_cnt == 2){
                prize += 2000;
                for(int j = 1 ; j <=6 ; j++){
                    if(cnt[j] == 2) prize += (j*500);
                }
            }
            else{
                if(max_cnt == 4){
                    prize = 50000+ max_v*5000;
                }
                else if(max_cnt ==3){
                    prize = 10000 + max_v*1000;
                }
                else if(max_cnt == 2){
                    prize = 1000 + max_v*100;
                }
                else{
                    for(int j = 1 ; j <=6 ; j++){
                        if(cnt[j] == 1 && max_v < j)
                            max_v = j;
                    }
                    prize = max_v*100;
                }
            }
            if(max < prize)
                max = prize;
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
