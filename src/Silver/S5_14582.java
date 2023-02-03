package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S5_14582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = false;
        int[] t1 =new int[9];
        int[] t2 = new int[9];
        int score = 0;
        for(int i = 0 ; i < 9 ; i++)
            t1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 9 ; i ++)
            t2[i] = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < 9 ; i++){
            score+=t1[i];
            if(score > 0) {
                flag = true;
                break;
            }
            score -=t2[i];
        }
        bw.write(flag == true ? "Yes" : "No");
        bw.flush();
    }
}
