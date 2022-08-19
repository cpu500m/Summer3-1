// 그냥 스택 두개 만들어서
// 하나는 차례대로넣고
// 역순으로 하나씩 빼면서 또 하나의 스택에 넣는식으로
// 구현하면 될것같아서 그렇게 구현
package Gold;

import java.io.*;
import java.util.StringTokenizer;

class Stack_17298{
    private int cur;
    private int cur_max;
    private int[] arr;
    Stack_17298(int N){
        cur = -1;
        cur_max = Integer.MIN_VALUE;
        arr = new int[N];
    }
    public void push(int value){
        arr[++cur] = value;
    }
    public int pop(){
        return arr[cur--];
    }
    public int peek(){
        if(cur == -1)
            return Integer.MAX_VALUE;
        return arr[cur];
    }
    public boolean isEmpty(){
        return cur == -1 ? true : false;
    }
}

public class G4_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack_17298 stack_inc = new Stack_17298(N);
        Stack_17298 stack_rev = new Stack_17298(N);
        StringBuilder sb = new StringBuilder();
        int[] NGE= new int[N];
        int cur_val;
        int cur_max = Integer.MIN_VALUE;
        for(int i = 0 ; i< N; i++){
            stack_inc.push(Integer.parseInt(st.nextToken()));
        }
        NGE[N-1] = -1;
        for(int i = N-1 ; i > 0 ; i--){
            stack_rev.push(stack_inc.pop());
            while(stack_rev.peek() <= stack_inc.peek()){
                stack_rev.pop();
            }
            if(stack_rev.isEmpty())
                NGE[i-1]  = -1;
            else
                NGE[i-1] = stack_rev.peek();
        }
        for(int i = 0 ; i < N ; i++)
            sb.append(NGE[i]+" ");
        bw.write(sb.toString());
        bw.flush();
    }
}
