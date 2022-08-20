package Silver;

import java.io.*;
import java.util.StringTokenizer;

// 원형큐
class Queue_18258{
    private int front;
    private int rear;
    private int[] arr;
    int max_size;
    Queue_18258(int size){
        front = 0;
        rear = 0;
        this.max_size = size+1;
        arr = new int[size+1];
    }
    public void push(int n){
        rear = (rear+1) % max_size;
        arr[rear] = n;
    }
    public int pop(){
        if(isEmpty() == 1)
            return -1;
        front = (front+1) % max_size;
        return arr[front];
    }
    public int isEmpty(){
        if(front == rear)
            return 1;
        else return 0;
    }
    public int size(){
        return front <= rear ? rear-front : max_size-front+rear;
    }
    public int front(){
        if(isEmpty() == 1)
            return -1;
        return arr[(front+1)% max_size];
    }
    public int back(){
        if(isEmpty() == 1)
            return -1;
        return arr[rear];
    }
}

public class S4_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue_18258 queue = new Queue_18258(N);
        String str;
        StringBuilder sb=  new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            if(str.equals("push"))
                queue.push(Integer.parseInt(st.nextToken()));
            else if(str.equals("front"))
                sb.append(queue.front()+"\n");
            else if(str.equals("pop"))
                sb.append(queue.pop()+"\n");
            else if(str.equals("size"))
                sb.append(queue.size()+"\n");
            else if(str.equals("empty"))
                sb.append(queue.isEmpty()+"\n");
            else if (str.equals("back"))
                sb.append(queue.back()+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
