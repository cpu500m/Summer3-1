package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;


public class S1_12852 {
    static class Value{
        int pre_val , cnt;
        Value(int pre, int cnt){
            this.pre_val = pre;
            this.cnt =cnt;
        }
    }
    static Value[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        dp = new Value[N+1];
        // index
        int i;

        Stack<Integer> stack = new Stack<>();
        for(i = 0 ; i <= N ; i++)
            dp[i] = new Value(-1 , Integer.MAX_VALUE);
        search(N, 0, -1);
        bw.write(String.valueOf(dp[1].cnt)+"\n");
        int cur = 1;
        while (cur != -1){
            stack.push(cur);
            cur = dp[cur].pre_val;
        }
        while (!stack.isEmpty()){
            bw.write(stack.pop()+" ");
        }
        bw.flush();
    }
    static void search(int cur,int cnt, int pre){
        if(dp[cur].cnt <= cnt || cur < 1)
            return ;
        dp[cur].cnt = cnt;
        dp[cur].pre_val = pre;
        if(cur % 3 == 0)
            search(cur/3, cnt+1 , cur);
        if(cur %2 == 0)
            search(cur/2 , cnt+1, cur);
        search(cur-1, cnt+1, cur);
    }
}
