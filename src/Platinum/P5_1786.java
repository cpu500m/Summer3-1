// 삼성 SW 문제 풀겸 결이 같아서 푼 문제인데
// KMP 알고리즘에 대해 잘 몰라서 아래 글을 참조
// https://bowbowbow.tistory.com/6
package Platinum;

import java.io.*;
import java.util.Arrays;

public class P5_1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int result = 0;
        String str = br.readLine();
        String comp = br.readLine();

        // 이동 테이블 구축
        int[] table = new int[comp.length()];
        Arrays.fill(table , 0);
        int j = 0;
        for(int i = 1 ; i < comp.length() ; i++){
            while (j > 0 && comp.charAt(j) != comp.charAt(i))
                j = table[j-1];
            if(comp.charAt(j) == comp.charAt(i))
                table[i] = ++j;
        }

        j  = 0;
        for(int i = 0 ; i < str.length() ; i++){
            while(j > 0 && str.charAt(i) != comp.charAt(j))
                j = table[j-1];
            if(comp.charAt(j) == str.charAt(i)){
                if(j == comp.length()-1){
                    sb.append((i-(j-1))+"\n");
                    result++;
                    j = table[j];
                }
                else j++;
            }
        }

        bw.write(result+"\n"+sb.toString());
        bw.flush();
    }
}

