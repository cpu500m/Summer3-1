// 그냥 제공하는 자료구조 써도되지만 복습도할겸 겸사겸사 직접 만들어서 쓰는걸로 해봄

package Silver;

import java.io.*;
import java.util.StringTokenizer;

class Stack_1260{
    private int[] stack;
    private  int top;
    private int max_size;
    Stack_1260(int size){
        top = -1;
        stack = new int[size];
        max_size = size;
    }
    boolean is_full(){
        return top == max_size-1;
    }
    boolean is_empty(){
        return top == -1;
    }
    boolean push(int n){
        if(is_full())
            return false;
        stack[++top] = n;
        return true;
    }
    int pop(){
        if(is_empty())
            return -1;
        return stack[top--];
    }
    int peek(){
        if(is_empty())
            return -1;
        return stack[top];
    }
}
class Queue_1260{
    private int front;
    private int rear;
    private int max_size;
    int[] circular_queue;
    Queue_1260(int size){
        circular_queue = new int[size+1];
        front = 0;
        rear = 0;
        max_size = size+1;
    }
    boolean is_full(){
        return (rear+1)%max_size == front;
    }
    boolean is_empty(){
        return front == rear;
    }
    boolean add(int n){
        if(is_full())
            return false;
        rear = (rear+1)%max_size;
        circular_queue[rear] = n;
        return true;
    }
    int poll(){
        if(is_empty())
            return -1;
        front = (front+1)%max_size;
        return circular_queue[front];
    }
}
public class S2_1260 {
    static StringBuilder sb;
    final static int ERROR = -1;
    static boolean[] visit;
    static boolean[][] connect;
    static Stack_1260 stack;
    static Queue_1260 queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cur_node = Integer.parseInt(st.nextToken());
        // index
        int i , a,b;
        stack = new Stack_1260(n);
        queue = new Queue_1260(n);

        // 0번노드는 사용 X
       visit = new boolean[n+1];
       connect = new boolean[n+1][n+1];

        for(i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            connect[a][b] = true;
            connect[b][a] = true;
        }

        // DFS부터 수행
        dfs(cur_node, n);
        sb.append("\n");
        visit = new boolean[n+1];
        bfs(cur_node , n);
        bw.write(sb.toString());
        bw.flush();
    }
    static void dfs(int cur_node, int n ){
        int i;
        boolean flag = true;
        visit[cur_node] = true;
        stack.push(cur_node);
        sb.append(cur_node+" ");
        while(!stack.is_empty()) {
            // 이게 제거를 하니깐 문제가 생겼던거임 고치자
            cur_node = stack.peek();
            flag = false;
            for (i = 1; i <= n; i++) {
                if (connect[cur_node][i] == true && visit[i] == false) {
                    stack.push(i);
                    cur_node = i;
                    sb.append(i+" ");
                    visit[cur_node] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag)
                stack.pop();
        }
    }
    static void bfs(int cur_node, int n){
        int i;
        visit[cur_node] = true;
        queue.add(cur_node);
        sb.append(cur_node+" ");
        while(!queue.is_empty()){
            cur_node = queue.poll();
            for(i = 1; i <= n ; i++){
                if(connect[cur_node][i] == true && visit[i] == false){
                    queue.add(i);
                    sb.append(i+" ");
                    visit[i] = true;
                }
            }
        }
    }
}
