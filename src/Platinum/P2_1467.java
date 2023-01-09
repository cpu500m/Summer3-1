// 예를들어 주어진 문자가 123123 이라면?
// 일단 앞에서부터 검사를 해서 가장작은 숫자가 1 .
// 그러면 1을 제거해야겠다 라고 생각하니깐 이거는 뭐 별 도움이안되는 케이스같고.
// 681362 라면 우선 맨 앞의 1을 제거하고 , 그다음 2가 있으면 또 제거하고.  해서 가다가
// 6을 제거해야한다면 맨 앞 6을 제거하고..
// 그러면 그냥 맨앞부터 순차적으로 하면 되는거아닌가? 오름차순으로 한다음에?
// 근데 313에서 3을 제거한다면? 뒤에3을 제거해야하는데?
// 그러면 수를 지울때 바로 뒤에있는 자리수와 비교한다?
// 좀 일리있는데?
// 일단 지워야할 숫자들 오름차순으로 정렬한다음에
// 만약에 지워야하는 숫자 찾았는데 뒤에있는 숫자가 더크다? 그럼 일단넘겨
// 근데이제 유일하게 그거하나다. 그러면은 그냥 그거지워.
// 근데이제 그렇게 해보니깐
// 423142 에서 4 , 3 , 2를 지우면
// 421이 아닌 412이 출력.
// 그 이유는 423142 에서 2번째자리인 2보다 3번째자리인 3이 커서 이를 선택했지만
// 3은 곧 지워질 숫자였기 때문임...
// 그래서 한참을 다시생각해보았는데

// 그러면 그때 그떄 문자를 지우는 것이 아니라
// 일단 체크만 해놨다가 나중에 지우는 것은 어떨까? 임
// 그를 위해 char 배열로 받는 것이아닌
/// 우선순위 큐를 이용하기로 함. ( 삽입과 삭제 작업이 잦을 것 같아서)

package Platinum;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P2_1467 {
    static class Temp{
        char c;
        int idx;
        Temp(int idx, char c){
            this.c =c;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        // 입력 처리
        StringBuilder origin = new StringBuilder(br.readLine());
        String delete_str = br.readLine();
        Queue<Character> asc_queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1-o2;
            }
        });

        // 2에게도 기회를 주기위한 큐
        Queue<Temp> chance_queue = new PriorityQueue<>(new Comparator<Temp>() {
            @Override
            public int compare(Temp o1, Temp o2) {
                return o2.c- o1.c;
            }
        });

        // index
        int i, j ;
        int target_idx;
        int  back_value;
        for(i = 0 ; i <delete_str.length() ; i++)
            asc_queue.add(delete_str.charAt(i));

        char comp;
        // 마지막 문자 검사위함
        boolean flag;
        // 어떤 문자를 지우기로 했는지 체크
        boolean[] check = new boolean[origin.length()];

        /*       로직          */
        while(!asc_queue.isEmpty()){
            // cur_max 를 통해 지워진 값 로직 수행
            back_value =  -1;
            target_idx = -1;
            comp = asc_queue.poll();
            flag = true;
            // 기존 문자열의 맨 왼쪽 자리부터 검사하며 위 로직을 따른다.
            for( i = 0 ; i < origin.length()-1 ; i++){
                // 지워지기로 한 놈이 아니고 , 지우는 대상이면 조건문에 들어간다.
                if(comp == origin.charAt(i) && !check[i]){
                    target_idx = i;
                    // 뒤에가 더 크다면 . 해당하는 애를 선택.
                    for(j = i+1 ; j < origin.length(); j++){
                        if(check[j] == false)
                            break;
                    }
                    if(j != origin.length() && origin.charAt(i) < origin.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                if (origin.charAt(origin.length() - 1) == comp && check[origin.length()-1] == false)
                    target_idx = origin.length() - 1;
            }
            // 이 사이에 32312 에서 2, 3 을 지우는 경우. 이런 경우를 처리하는 로직이 들어가야함.
            // 3312에서 3을 지웠을때 이전에 앞에서 지워진 애들 중에 뒤에 check가 false인 ( 아직 안지워진)
            // 애보다 큰 애가 존재하는지를 봐서 존재한다면 살려줘야지.
            // 그니깐 이제 자기 자신을 지우고 살려줘야지. 근까 312 로 만든다음에 2를살려줘서 3212로 만들고
            // 다시 2를 지우는 로직을 수행하는거임. 그럼 321 로 최적이 되겠지.


            // 여기서 문제가 있엇음.
            // 4231 라는 애가있고 4랑 2는 지워진 애임.
            // 3을 지울 차롄데 이러면 4한테만 다시 살아날 기회를주고 2는 버려짐.
            // 2한테도 기회를 주도록 해야함.

            // back 찾기
            for(i = target_idx+1 ; i < origin.length() ; i++){
                if(check[i] == false){
                    back_value = origin.charAt(i) -'0';
                    break;
                }
            }
            // front 찾기.
            for(i = target_idx-1 ; i >=0 ; i--){
                if(check[i] == false)
                    break;
                if(back_value <= origin.charAt(i)- '0') {
                    chance_queue.add(new Temp(i, origin.charAt(i)));
                }
            }
            // 지우기로 한 애에다가 표시를 해놓는다.
            check[target_idx] = true;

            // 앞에서 말한 로직대로 복원을 수행한다.
            while (!chance_queue.isEmpty()){
                Temp t = chance_queue.poll();
                check[t.idx] = false;
                asc_queue.add(t.c);
            }
        }

        /*       출력 부분        */
        for(i = 0 ; i < origin.length(); i++){
            if(check[i] == false)
                sb.append(origin.charAt(i));
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
