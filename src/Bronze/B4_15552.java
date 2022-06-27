/* 2022-06-27 */
// Scanner를 이용하여 입력을 받는것보다 BufferedReader ,
// System.out.println을 이용하여 출력하는 것 보다 BufferedWriter를 사용하는 것이
// 시간 측면에서 유리하다고 하여 사용법을 알아볼 겸 해본 문제
// parseInt는 기본 자료형을 리턴하고,valueOf은 객체를 리턴함.
// 즉 , valueOf내부에서 결국 parseInt를 호출함. 그러므로 시간적인 측면에서 parseInt를 쓰는 것이 유리함.
package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B4_15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        StringTokenizer st;
        int loop_count = Integer.parseInt(br.readLine());
        for(int i = 0; i < loop_count ; i++){
            st = new StringTokenizer(br.readLine());
            bw.write((Integer.parseInt(st.nextToken()))+(Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
    }
}
