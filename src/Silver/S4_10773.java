package Silver;

import java.io.*;

class Stack_10773{
    private int[] s;
    private int cur;
    private int sum;
    Stack_10773(int K){
        s = new int[K];
        cur = -1;
        sum = 0;
    }
    void push(int n){
        if(n == 0) {
            sum-=s[cur--];
        }
        else {
            s[++cur] = n;
            sum+=n;
        }
    }

    public int getSum() {
        return sum;
    }
}
public class S4_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        Stack_10773  stack = new Stack_10773(K);
        for(int i = 0 ; i <K; i++){
            stack.push(Integer.parseInt(br.readLine()));
        }
        bw.write(String.valueOf(stack.getSum()));
        bw.flush();
    }

}
