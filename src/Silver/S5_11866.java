package Silver;

import java.io.*;
import java.util.StringTokenizer;


class Queue_11866{
    private int front;
    private int rear;
    private int[] arr;
    private int max_size;
    Queue_11866(int size){
        front = 0;
        rear = 0;
        arr = new int[size+1];
        max_size = size+1;
    }
    public void push(int n){
        rear = (rear+1) % max_size;
        arr[rear] = n;
    }
    public boolean isEmpty(){
        if(front == rear)
            return true;
        return false;
    }
    public int size(){
        return front <= rear ? rear-front : max_size-front+rear;
    }
    public int pop(){
        if(isEmpty())
            return -1;
        front = (front+1)%max_size;
        return arr[front];
    }
}
public class S5_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int temp;
        StringBuilder sb = new StringBuilder();
        Queue_11866 queue = new Queue_11866(N);
        sb.append("<");
        if (N == 1) {
            bw.write("<1>");
            bw.flush();
            return;
        }
        for (int i = 1; i <= N; i++)
            queue.push(i);
        if (K == 1) {
            for (int i = 0; i < N - 1; i++) {
                sb.append(queue.pop() + ", ");
            }
            sb.append(queue.pop() + ">");
            bw.write(sb.toString());
            bw.flush();
            return;
        }
        while (queue.size() > 1) {
            for (int j = 0; j < K - 1; j++) {
                temp = queue.pop();
                queue.push(temp);
            }
            sb.append(queue.pop() + ", ");
        }
        sb.append(queue.pop()+">");
        bw.write(sb.toString());
        bw.flush();
    }
}
