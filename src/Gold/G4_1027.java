package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 빌딩 높이 저장
        int[] building = new  int[N];
        // 보이는 고층 건물 저장
        int[] cnt = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine() ," ");
        for(int i = 0 ; i < N ; i++)
            building[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(cnt , 0);

        for(int i = 0 ; i < N ; i++){
            float cur = Integer.MAX_VALUE;
            float slope;
            for(int j = i-1 ; j >= 0 ; j--){
                slope = (building[i]-building[j])/(float)(i-j);
                if ( slope < cur) {
                    cnt[i]++;
                    cur = slope;
                }
            }
            cur = Integer.MAX_VALUE;
            for(int j = i+1 ; j < N ; j++){
                slope = (building[i]-building[j])/(float)(j-i);
                if(slope < cur) {
                    cnt[i]++;
                    cur = slope;
                }
            }
        }
        int max = -1;
        for(int i = 0 ; i <N ; i ++)
            if(max < cnt[i])
                max = cnt[i];

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
