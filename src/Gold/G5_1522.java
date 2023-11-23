// 일정 범위 잡고 범위길이 - b의 개수 해서 최적값 구하면 정답일듯
// 시간복잡도 O(n^2 * logn ) 이하여야하는데
// O(N^2)이네 ㅇㅋ
package Gold;

import java.io.*;

public class G5_1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        // 최적 길이
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a')
                len++;
        }

        int start = 0;
        int optVal = 1001;
        while (true){
            int cnt = 0;
            int cur = start;
            for (int i = 0; i < len; i++) {
                if(str.charAt(cur) == 'b') cnt++;
                cur = (cur+1)%str.length();
            }
            if(optVal > cnt) optVal = cnt;
            start = (start + 1) % str.length();
            if(start == 0)break;
        }
        bw.write(String.valueOf(optVal));
        bw.flush();
    }
}
