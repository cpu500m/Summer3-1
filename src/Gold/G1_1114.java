// 우선순위 큐를 하나 만들어서 통나무 길이가 가장 긴거를 쪼개는 형식으로 해볼예정.
// 음근데 자고일어나서 이제 풀어보려고 생각하는데
// 그냥 K번 나눴으면
// 총 k+1개의 조각으로 나뉘어졌을거아님?
// 그러면 k+1개의 배열을 만들어서
// K번 나눴을때의 각 통나무 길이를 다 저장해놓는거임.
// 그리고나서 오름차순으로 정렬해놨다가
// C번 자를 수있으니까 C+1개로 합쳐질때까지 합치고 가장 작은 통나무 길이 출력하면.. 될거긴한데 흠 구현이..
// ( 우선순위 큐를 이용하여 오름차순 정렬하되  길이 같다면 인덱스 큰애 우선 ( 왼쪽부터 자르려고)
// 일단 뭐 얼마 안걸릴거같으니까 한번해봄.

// 해봤는데 통나무 조각이 1 8 3 4 과 같이 있고 3조각으로 만들어야한다면
// 이게 1이랑 8을 합쳐버리는데 근데 3이랑 4를 합쳐서 7을 만드는게 최적이어서 안됨.
// 그래서 다른 방식을 좀 생각해봐야함

// 생각난게
// 음 이분 탐색을 좀 이용해보는것은 어떨까 싶음.
// 그니깐 이제 통나무들을 C+1개로 잘라내는게 목표잖아.
// 예를들어 길이 9를 3조각으로 자르면 3 3 3 이최적이잖아 이론상? 그럼 가장 긴 통나무 길이가 3이고?
// 그러면 왼쪽부터 통나무를 자르는데 일단 1부터 시작해서 (C+1)/L 의 길이로 자를 수 있는지 까지를 이분탐색으로 조사함.
// 그래서 최적의 경우를 찾으면 그 때 ( L -  마지막 으로 쪼갠지점 ,  처음으로 쪼갠지점 )을
// 출력으로 내보내면 될거같음. 괜찮은데? 해봄
// 근데 계속 안돼서 왜안되지하고 곰곰히 생각해봤는데.. 반드시 C+1 토막 내야하는건 또 아니었음. 그냥 최대 C+1토막 까지 가능하단거지

// 근데 막상 해보니 왼쪽부터 쪼개니 골치아파서 오른쪽부터 쪼개는걸로.
// 그니깐 이분탐색하면서 K길이 이하로 모든 조각 쪼갤수 있다면 OK

package Gold;

import java.io.*;
import java.util.*;

public class G1_1114 {
    static int[] split_idx;
    static int[] len;
    static int idx , length , C, L , K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /* 입력 처리 */
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 통나무를 쪼갤 수 있는 지점
        split_idx = new int[K+2];
        // 각 쪼갠 통나무 길이
        len = new int[K+1];
        int start = 1 , end = L ,mid;
        // index
        int i;


        // 나뉜 부분 입력 처리
        st = new StringTokenizer(br.readLine());
        split_idx[0] = 0;
        for(i = 1 ; i <= K ; i++)
            split_idx[i] = Integer.parseInt(st.nextToken());
        split_idx[K+1] = L;


        // 인덱스를 오름차순으로 정렬
        Arrays.sort(split_idx);

        for( i = 0 ; i < K+1; i++)
            len[i] = split_idx[i+1]-split_idx[i];

        /*      로직      */
        while (start <= end){
            mid = (start+end)/2;
            if(cut(mid))
                end =  mid-1;
            else
                start = mid+1;
        }
        bw.write(String.valueOf(length)+" "+String.valueOf(idx));
        bw.flush();

    }
    static boolean cut(int mid) {
        // index
        int i;
        int cur_log = 0 , count = 0 , remain = -1;
        for(i = K;  i >= 0 ; i--){
            // 통나무가 mid보다 크다면 그 직전에 자름.
            // 근데 최소 덩어리가 mid보다 크다면 안되는거니까 false.
            if(cur_log + len[i] > mid){
                if(len[i] > mid)
                    return false;
                count++;
                cur_log = len[i];
                remain = split_idx[i+1];
            }
            else{
                cur_log += len[i];
            }
            if(count == C)
                break;
        }
        if(remain > mid)
            return false;

        idx = remain;
        length = mid;
        if( count < C)
            idx = split_idx[1];
        return true;
    }
}
