// 시간복잡도 개선에 조금더 신경을 써서 설계해봄. 일단
// N이 최악 10만이니깐
// temp : ( 4* 100,000 ) * 2 = 800KB
// gift 객체 배열 공간 약 1~2MB잡으면
// 메모리는 일단 OK
// 시간초과 문제가 발생해서 시간을 좀 생각해봄.
// 1에서 30만번 + a
// 2에서 30만번 + a
// 3에서 처음에는 이중 for 문을 사용해서 하는식으로 했는데
// 이렇게하면 예를들어 극단적으로 정렬된 첫번째 기프티콘의 유효기간이 10억이라면
// 루프가 1억번 이상 돌게되므로 문제가 있다는걸 깨달음.
// 그래서 다음번 인덱스만 검사하되
// 만약 다음번 인덱스와 그 이후 인덱스들의 사용날짜가 같다면 거기까지 수정해주는 그런식으로 시간 문제를 해결했음.


package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class gift_17420{
    int remain;
    int plan;
    gift_17420(int remain, int plan){
        this.remain = remain;
        this.plan =  plan;
    }
}
public class G1_17420 {
    static gift_17420[] gift;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int i, j;
        int cur_remain, cur_plan;
        int max_v=0;
        long result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] temp1 = new int[n];
        int[] temp2 = new int[n];

        gift = new gift_17420[n];

        // 입력 처리 ---- 1
        for (i = 0; i < n; i++)
            temp1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (i = 0; i < n; i++)
            temp2[i] = Integer.parseInt(st.nextToken());
        for (i = 0; i < n; i++)
            gift[i] = new gift_17420(temp1[i], temp2[i]);

        // 로직.
        // 우선 기한을 연장 시켜줌 ---- 2
        for (i = 0; i < n; i++) {
            if (gift[i].remain >= gift[i].plan)
                continue;
            if ((gift[i].plan - gift[i].remain) % 30 == 0) {
                result += (gift[i].plan - gift[i].remain) / 30;
                gift[i].remain += ((gift[i].plan - gift[i].remain) / 30) * 30;
            } else {
                result += ((gift[i].plan - gift[i].remain) / 30 + 1);
                gift[i].remain += ((gift[i].plan - gift[i].remain) / 30 + 1) * 30;
            }

        }

        // 그 후 , 사용 기한 기준 오름차순으로 정렬해줌.
        Comparator<gift_17420> comparator = new Comparator<>() {
            @Override
            public int compare(gift_17420 a, gift_17420 b) {
                if (a.plan - b.plan == 0)
                    return a.remain - b.remain;
                return a.plan - b.plan;
            }
        };
        Arrays.sort(gift, comparator);

//        for(i = 0 ; i < n ; i++)
//            bw.write(gift[i].plan+" "+gift[i].remain+"\n");
//        bw.write("\n");

        // 그 후 사용기한 작은 애부터 사용하되
        // 사용기한이 큰 애중에 현재 쓰는 애보다 기프티콘 유효기간이 길다면 그들을 연장해야함. --- 3
//        max_v = gift[0].remain;
        for(i = 0 ; i < n-1 ; i++){
//            cur_remain = gift[i].remain;
            if(max_v < gift[i].remain)
                max_v = gift[i].remain;
            cur_plan = gift[i].plan;
            j = i+1;
            if(cur_plan == gift[j].plan) {
                if (max_v < gift[j].remain)
                    max_v = gift[j].remain;
                continue;
            }
            if(gift[j].remain < max_v){
                if((max_v-gift[j].remain) %  30 == 0) {
                    result += (max_v - gift[j].remain)/30;
                    gift[j].remain += ((max_v - gift[j].remain)/30 ) * 30;
                }
                else{
                    result += ((max_v - gift[j].remain)/30 +1);
                    gift[j].remain += ((max_v - gift[j].remain)/30 +1) * 30;
                }
            }

            cur_plan = gift[j].plan;
            while(j != n-1 && cur_plan == gift[++j].plan ){
                if(gift[j].remain < max_v){
                    if((max_v-gift[j].remain) %  30 == 0) {
                        result += (max_v - gift[j].remain)/30;
                        gift[j].remain += ((max_v - gift[j].remain)/30 ) * 30;
                    }
                    else{
                        result += ((max_v - gift[j].remain)/30 +1);
                        gift[j].remain += ((max_v - gift[j].remain)/30 +1) * 30;
                    }
                }
                cur_plan = gift[j].plan;
                }

        }
        for(i = 0 ; i < n ; i++)
            bw.write(gift[i].plan+" "+gift[i].remain+"\n");
        bw.write(String.valueOf(result));
        bw.flush();

    }
}
