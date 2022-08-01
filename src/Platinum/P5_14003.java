// LIS 클래스에 자기 index 정보를 같이 저장하고,
// 수열 정보 저장하는 클래스에 자기 이전 인덱스를 마크하게 해서
// 약간 파일 관리할떄처럼 첫번째 시작 인덱스는 -1로해서
// LIS 마지막번째의 index부터 시작해서 거슬러올라감.
// 그다음 큐에 하나하나 저장하고 꺼내면 될듯?
package Platinum;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Sequence{
    private int number;
    private int pre_index;
    Sequence(int number ){
        this.number = number;
        pre_index = -1;
    }

    public int getNumber() {
        return number;
    }

    public int getPre_index() {
        return pre_index;
    }

    public void setPre_index(int pre_index) {
        this.pre_index = pre_index;
    }
}

public class P5_14003 {
    private static int[] LIS;
    private static int[] LIS_index;
    private static int LIS_length;
    private static Sequence[] sequence;
    private static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int cur_num;
        sequence = new Sequence[N+1];
        LIS = new int[N+1];
        LIS_index = new int[N+1];
        Arrays.fill(LIS,Integer.MAX_VALUE);
        Arrays.fill(LIS_index,-1);
        LIS_length = 1;
        stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sequence[i] = new Sequence(Integer.parseInt(st.nextToken()));
            cur_num =sequence[i].getNumber();
            if(cur_num > LIS[LIS_length]){
                LIS[LIS_length+1] = cur_num;
                LIS_index[++LIS_length] = i;
                sequence[i].setPre_index(LIS_index[LIS_length-1]);
            }
            else
                getLIS(i);
        }
        int num =LIS[LIS_length];
        int pre_idx = sequence[LIS_index[LIS_length]].getPre_index();
        while(pre_idx != -1){
            stack.push(num);
            num = sequence[pre_idx].getNumber();
            pre_idx = sequence[pre_idx].getPre_index();
        }
        stack.push(num);
        while(!stack.isEmpty())
            sb.append(stack.pop()+" ");
        bw.write(String.valueOf(LIS_length)+"\n"+sb.toString());
        bw.flush();
    }
    private static void getLIS(int N) {
        int lower_bound = 1;
        int upper_bound = LIS_length;
        while(lower_bound < upper_bound){
            int mid = (lower_bound+upper_bound)/2;
            if(LIS[mid] < sequence[N].getNumber()){
                lower_bound = mid+1;
            }
            else
                upper_bound = mid;
        }
        LIS[lower_bound] = sequence[N].getNumber();
        sequence[N].setPre_index(LIS_index[lower_bound-1]);
        LIS_index[lower_bound] = N;
    }
}
