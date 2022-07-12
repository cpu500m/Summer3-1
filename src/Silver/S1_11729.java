/* 2022-07-12 */
// 1. n개의 원판이 1번 위치에 있을 때 n-1개를 2번으로 이동.
// 2. 1번 위치에 남아있는 원판을 3번 위치로 이동
// 3 . n-1개를 3번위치로 옮기기 위해 함수 재귀 호출.
// ( 이 때는 1번이 경유지가 되어 1번에 n-1개를 놓고 2번 위치의 맨 아래 원판을 3번위치로 옮기는 형식.)
// 그 다음으로 1번위치에서 n-1개의 원판을 2번으로 옮기고
// 3번 위치에 1번위치의 맨 아래 원판을 옮김.
// from 은 출발 to는 도착 passing은 경유 ( n-1개의 원판을 두는 곳)
package Silver;

import java.io.*;

public class S1_11729 {
    static int count = 0;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        hanoi(n,1,2,3);
        bw.write(count+"\n"+sb.toString());
        bw.flush();
    }
    public static void hanoi(int n , int from , int passing , int to){
        count ++;
        if( n==1){
            sb.append(from+" "+to+"\n");
        }
        else{
            hanoi(n-1,from,to,passing);
            sb.append(from+" "+to+"\n");
            hanoi(n-1,passing,from,to);
        }
    }
}
