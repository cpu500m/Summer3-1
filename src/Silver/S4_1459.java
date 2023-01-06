package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y =Long.parseLong(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        long result = 0, cross;

        // 맨헤튼 거리가 유클리드 거리보다 짧다면 그냥 멘해튼 거리로 가기
        if(2*w <= s)
            result = x*w+y*w;
        // 멘헤튼 거리가 유클리드 거리보단 길지만 좌표상 직선거리가 유클리드 거리보다 짧은 경우
        else if(w <= s){
            cross = Math.min(x,y);
            result+= cross*s;
            x -=cross;
            y-=cross;
            result+= ( x*w + y*w);
        }
        // 좌표상 직선거리가 유클리드 거리보다 긴 경우.
        else{
            cross = Math.min(x,y);
            result += cross*s;
            x -= cross;
            y -= cross;
            cross = Math.max(x,y);
            if(cross % 2 == 0){
                result+= cross*s;
            }
            else{
                result += (cross-1)*s;
                result += w;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
