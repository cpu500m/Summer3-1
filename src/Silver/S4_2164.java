package Silver;

import java.io.*;

class Queue_2164{
    private int front;
    private int rear;
    private int[] arr;
    private int max_size;
    Queue_2164(int size){
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
    public int pop(){
        if(isEmpty())
            return -1;
        front = (front+1)%max_size;
        return arr[front];
    }
}

public class S4_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cur= 0, val=0;
        Queue_2164 queue = new Queue_2164(N);
        for(int i = 1; i<= N ; i++)
            queue.push(i);
        while(true){
            val = queue.pop();
            if((cur = queue.pop()) ==-1){
                bw.write(String.valueOf(val));
                bw.flush();
                break;
            }
            queue.push(cur);
        }
    }
}
