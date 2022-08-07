// 제일먼저 생각나는 방법은
// 그냥 a~z까지 2차원 배열 만들어서
// 각각에 대해 만들어 놓는거임
// 그러면 시간 충분 메모리 충분함
package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S1_16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        String str = br.readLine();
        char c;
        int q = Integer.parseInt(br.readLine());
        int[][] count = new int[26][str.length()+1];
        for(int i = 0 ; i < str.length() ; i++){
            for(int j = 0 ; j < 26 ; j++)
                count[j][i+1] = count[j][i];
            count[str.charAt(i)-'a'][i+1]++;
        }
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine());
            c = st.nextToken().charAt(0);
            sb.append(Math.abs(count[c-'a'][Integer.parseInt(st.nextToken())] - count[c-'a'][Integer.parseInt(st.nextToken())+1])+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
