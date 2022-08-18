package Silver;

import java.io.*;

class Stack_1874{
    private int cur;
    private int[] arr;
    private int cur_value;
    Stack_1874(int N){
        arr = new int[N];
        cur = -1;
        cur_value = 0;
    }
    void push(){
        arr[++cur] = ++cur_value;
    }
    int pop(){
        return arr[cur--];
    }

    public int getCur() {
        return cur;
    }

    public int getCur_value() {
        return cur_value;
    }
    public int getValue(){
        return arr[cur];
    }
}
public class S2_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int val;
        StringBuilder sb = new StringBuilder();
        Stack_1874 stack = new Stack_1874(N);
        for(int i = 0 ; i < N ; i++){
            val =  Integer.parseInt(br.readLine());
            while (stack.getCur_value() < val){
                sb.append("+\n");
                stack.push();
            }
            if(stack.getValue() == val) {
                sb.append("-\n");
                stack.pop();
            }
            else{
                bw.write("NO");
                bw.flush();
                return ;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
