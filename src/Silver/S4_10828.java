package Silver;

import java.io.*;
import java.util.StringTokenizer;

class My_Stack{
    int[] s;
    int cur;

    My_Stack(int N){
        s = new int[N];
        cur = 0;
    }
    public void push(int x){
        s[cur++] = x;
    }
    public int pop(){
        if(cur == 0){
            return -1;
        }
        else
            return s[--cur];
    }
    public int size(){
        return cur;
    }
    public int empty(){
        if (cur == 0)
            return 1;
        else
            return 0;
    }
    public int top(){
        if(cur == 0)
            return -1;
        else
            return  s[cur-1];
    }
}
public class S4_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String command;
        int N = Integer.parseInt(br.readLine());
        My_Stack stack = new My_Stack(N);
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if( command.equals("push"))
                stack.push(Integer.parseInt(st.nextToken()));
            else if( command.equals("top"))
                sb.append(stack.top()+"\n");
            else if( command.equals("empty"))
                sb.append(stack.empty()+"\n");
            else if( command.equals("size"))
                sb.append(stack.size()+"\n");
            else if( command.equals("pop"))
                sb.append(stack.pop()+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
