// 그냥
// 5자리면
// 1자리 만들때까지 , 2자리 만들떄까지 .. 가지수 구하면 되는거아님?
// k자리코드를 만들때가지는 k-2자리까지 만들떄 경우의수 + k-1까지
// 인데 만약에 k -1 자리수와 k 자리수의 조합이 26의 범위를 벗어나면 그냥 k-1까지것만 더하면 되는거자나

// ㅋㅋ 아 문제가 해석이좀;

package Gold;

import java.io.*;

public class G5_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder code = new StringBuilder(br.readLine());
        if(code.length() == 0){
            bw.write("0");
            bw.flush();
            return ;
        }
        int[] count = new int[code.length()+1];

        // index
        int i;

        /*      로직      */
        boolean flag = false;
        // 시작 조건
        count[0] = 1;
        count[1] = 1;
        if(code.charAt(0) == '0')
            flag = true;
        for(i = 2; i < count.length ; i++){
            if(code.charAt(i-1) == '0')
                if( '0' < code.charAt(i-2) && code.charAt(i-2) < '3')
                    count[i] = count[i-2];
            else {
                flag = true;
                break;
                }
            else if(code.charAt(i-2) == '0')
                count[i] = count[i-1];
            else if(Character.getNumericValue(code.charAt(i-2))*10 + Character.getNumericValue(code.charAt(i-1)) <= 26)
                count[i] =(count[i-1]+count[i-2])%1_000_000;
            else
                count[i] = count[i-1];
        }

        if(!flag)
        bw.write(String.valueOf(count[code.length()]));
        else bw.write("0");
        bw.flush();
    }
}
