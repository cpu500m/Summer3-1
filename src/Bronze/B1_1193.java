// 분모+ 분자 합이 짝수 :  열 시작 . 홀수 : 행 시작
package Bronze;

import java.io.*;

public class B1_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int step = 1;
        int level = 1;
        int sum = 2;
        int position;
        while( n - step >0){
            level++;
            step+=level;
            sum+=1;
        }
        position = step-n;
        if(sum % 2 == 0){
            bw.write((sum-(level-position))+"/"+String.valueOf(level-position));
        }
        else{
            bw.write(String.valueOf(level-position)+"/"+(sum-(level-position)));
        }
        bw.flush();
    }
}
