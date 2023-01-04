// 일단 처음에 문제보고 생각한건 .. 좀 쉬울것 같은데? 라고생각함
// 클래스 하나 만들어서 데드라인 , 컵라면 수 저장하고
// 데드라인 기준으로 정렬하고
// 같은 데드라인에서 컵라면수 max 인 애 찾아서 결과값에 더하는 식으로.
// 근데 다시 생각해보니깐 그렇게는 해결이 안돼서
// 최대가 200,000개니깐
// 200,000개의 int 배열을 만들어서
// 1개문제를 풀때 최대 컵라면 , 2개 풀 때  , 3개 ... 이런식으로.
// 근데 또 바로 생각해보니깐 이거는 N^2에 근사하는 시간복잡도가 나오니깐
// 그냥 컵라면 수로 내림차순 정렬하고 포함 가능한지 불가능한지 여부만 따지는 식으로 그리디 알고리즘으로 해결하면 될 것같다 생각이 들었음.
// 근데 이거도 아래와 같은 예시를 생각해보니 안됨.
// 데드라인   2 3 1 3
// 컵라면     9 4 1 8
// 그래서 든 생각이 데드라인 기준 오름차순으로 정렬해서 하나하나 넣되
// int 배열을 만들어서 그동안 넣어둔 값을 기록해놓고 , 그 중 최저값과 바꾸는식으로.  그런식으로 한번 해보기로함. 시간이 좀 걸리긴하는데 2초니깐
// 일단 해보는걸로
// 해서 통과는 하긴 했는데 내가 생각하기엔 뭔가 시간복잡도가 아쉬워서 좀더 개선할 수 있는 방법이 없을까? 찾아보니
// 우선순위 큐라는게 있어서 그걸 공부 해봄.

package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Question_1781{
    int deadline , num_of_noodle;
    Question_1781(int deadline, int num_of_noodle){
        this.deadline = deadline;
        this.num_of_noodle = num_of_noodle;
    }
}

public class G2_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int i, j;
        long min;
        int min_idx, cur;
        long result = 0;
        long[] opt = new long[n];
        Question_1781[] quest = new Question_1781[n];

        // 입력 처리
        for( i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            quest[i] = new Question_1781(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // Comparator를 이용하여 데드라인 기준 오름차순 정렬.
        Comparator<Question_1781> comparator = new Comparator<Question_1781>() {
            @Override
            public int compare(Question_1781 o1, Question_1781 o2) {
                if(o1.deadline == o2.deadline)
                    return o2.num_of_noodle - o1.num_of_noodle;
                return o1.deadline - o2.deadline;
            }
        };
        Arrays.sort(quest, comparator);

        // 로직
        opt[0] = quest[0].num_of_noodle;
        result+= opt[0];
        cur = 1;
        min = opt[0];
        min_idx = 0;
        for(i = 1 ; i < n; i++){
            if(cur < quest[i].deadline){
                opt[cur] = quest[i].num_of_noodle;
                result += opt[cur];
                if(min > quest[i].num_of_noodle) {
                    min = quest[i].num_of_noodle;
                    min_idx = cur;
                }
                cur++;
            }
            else{
                if(min < quest[i].num_of_noodle){
                    result -= opt[min_idx];
                    opt[min_idx] = quest[i].num_of_noodle;
                    result += opt[min_idx];
                    min = Integer.MAX_VALUE;
                    for(j = 0 ; j < cur ; j++){
                        if(min > opt[j]){
                            min = opt[j];
                            min_idx = j;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();

    }
}
