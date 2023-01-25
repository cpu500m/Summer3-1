package Platinum;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class P5_2568 {
    private static int[][] wires;
    private static int[] LIS;
    private static int[] prev;
    private static int LIS_length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        /*  입력  처리  */
        int N = Integer.parseInt(br.readLine());
        wires = new int[N+1][2];
        LIS = new int[N+1];
        prev = new int[500_001];

        Arrays.fill(LIS,Integer.MAX_VALUE);
        // prev 배열을 통해 tracking 할 예정
        LIS_length = 1;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i =1 ; i <= N ; i++){
            if( wires[i][1] > LIS[LIS_length]) {
                LIS[++LIS_length] = wires[i][1];
                prev[wires[i][1]] = LIS[LIS_length -1];
            }
            else
                getLIS(i);
        }
        bw.write(String.valueOf(N-LIS_length)+"\n");

        int cur = LIS[LIS_length];
        Stack<Integer> stack = new Stack<>();
        for(int i = N; i > 0 ; i--){
            if(wires[i][1] == cur){
                cur = prev[cur];
                continue;
            }
            stack.push(wires[i][0]);
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop()+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static void getLIS(int N) {
        int lower_bound = 1;
        int upper_bound = LIS_length;
        while(lower_bound < upper_bound){
            int mid = (lower_bound+upper_bound)/2;
            if(LIS[mid] < wires[N][1]){
                lower_bound = mid+1;
            }
            else
                upper_bound = mid;
        }
        LIS[lower_bound] = wires[N][1];
        prev[wires[N][1]] = LIS[lower_bound-1];
    }
}
