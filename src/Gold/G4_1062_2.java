// int형 안에 담아서 해보자 한번..

package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G4_1062_2 {
    static int cur = 5;
    static int N,K;
    static int[] bit_string;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index
        int i,j;

        /*  입력  처리  */
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String str;
        bit_string = new int[N];
        int temp;

        /*      로직      */
        // 시작 비트스트링을 저장.
        int start = 0;
        String start_string = "antic";
        for( i = 0 ; i < 5; i++)
            start |= ( 1 <<( start_string.charAt(i)-'a'));

        // 단어들의 비트스트링 저장
        for( i = 0; i < N ; i++){
            str= br.readLine();
            temp = start;
            for(j = 4 ; j <str.length()-4 ; j++)
                temp |= (1<<(str.charAt(j)-'a'));
            bit_string[i] = temp;
        }

        // k가 5보다 작다면 안됨. a , n,t,i,c 다섯개는 무조건 잇어야하니깐 ㅇㅇ
        if(K < 5)
            bw.write("0");
        else{
            // a는 이미 표시된걸 아니깐 건너뛰고 시작 ㄱ
            back_tracking(1,start);
            bw.write(String.valueOf(result));
        }
        bw.flush();
    }
    static void back_tracking(int index, int mask){
        // index
        int i;
        if(cur == K){
            int count = N;
            for( i = 0; i < N ; i++){
                if((mask | bit_string[i]) != mask)
                    count--;
            }
            if(result < count)
                result = count;
            return ;
        }
        for( i  = index ; i < 26 ; i++){
            if((mask & (1<<i)) != 0)
                continue;
                cur++;
                back_tracking(i+1, mask | (1<<i));
                cur--;

        }
    }
}
