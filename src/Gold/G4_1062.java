// 그냥 대충 계산해봤는데
// 최대 N이 50이고
// 문자열 길이도 최대 15고
// 그냥 백트래킹 이용해서 하면 될듯.
// 일단 처음에 antic 다섯 문자는 무조건 있어야함. 그니깐
// K가 5보다 작다면 무조건 답은 0 임.
// 그래서 K가 5이상이라는 것을 전제로
// b,c,d ... 이런애들을 넣었다 뺐다 해보면서 만약
// 넣은 애들이 K개라면 최댓값인지 비교하고. 그런식으로 하면 될듯 쉽다

// 근데 시간초과가 나네?
// 흠.. N =50 K = 26으로 한번 생각해보자..
// K팩토리얼 만큼 돌아야하네..
// 다른 방법을 생각해봐야할듯..

// 흠,,, 그냥 루프 돌릴떄 이전에 검사한 곧은 검사 스킵하기 위해서
// 매개변수로 조사 시작하는 index 넘겨주면 될듯.

// 와 근데 내 코드에 조금 아쉬움이 남아서 다른 코드들을 좀 봤는데
// 그냥 각 단어마다 boolean 26개짜리 공간을 할당하는 것 보다
// 비트단위로 int타입으로 저장하는게 훨씬 시간 , 공간면에서 이득이라는걸 깨달음.
// 그래서 그런 코드좀 카피카피 해보자 라는 의도에서 한번 아이디어를 보고 내가 한번 짜봄.
// 그 코드는 G4_1062_2에서 ㅎㅎ

package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G4_1062 {
    static int cur = 5;
    static int N,K;
    static String[] set;
    static boolean[] check;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // index
        int i;

        /*  입력  처리  */
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new boolean[26];
        String str;
        set = new String[N];

        for( i = 0; i < N ; i++){
            str= br.readLine();
            set[i] = str.substring(4,str.length()-4);
        }

        /*      로직      */

        // 우선 반드시 등장하는 5가지는 true 표시 하고 시작.
        check['a'-'a']  = true;
        check['c'-'a'] = true;
        check['t'-'a'] = true;
        check['i'-'a'] = true;
        check['n'-'a'] = true;
        if(K < 5)
            bw.write("0");
        else{
            back_tracking(1);
            bw.write(String.valueOf(result));
        }
        bw.flush();
    }
    static void back_tracking(int index){
        // index
        int i, j;
        int value = 0;
        // 다 체크했을때 검사를 해봐야함.
        if(cur == K){
            for( i = 0 ; i <N; i++){
                value++;
                for(j = 0 ; j < set[i].length() ; j++)
                    if(!check[set[i].charAt(j)-'a']){
                        value--;
                        break;
                    }
            }
            if(result < value)
                result = value;
            return ;
        }

        for(i = index ; i < 26 ; i++){
            // 하나 체크표시 하고. 검사하고 그런식
            if(!check[i]){
                check[i] = true;
                cur++;
                back_tracking(i+1);
                cur--;
                check[i] = false;
            }
        }
    }
}
