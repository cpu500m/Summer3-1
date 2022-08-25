package Silver;

import java.io.*;
import java.util.StringTokenizer;

class Deck_1021{
    private int front;
    private int rear;
    private int[] arr;
    private int max_size;
    Deck_1021(int size){
        front = 0;
        rear = 0;
        max_size = size+1;
        arr = new int[size+1];
    }
    public void push_front(int n){
        arr[front] = n;
        front = (front > 0 ? (front-1)%max_size : max_size-1);
    }
    public void push_back(int n){
        rear = (rear+1)%max_size;
        arr[rear] = n;
    }
    public int pop_front(){
        if(rear==front)
            return -1;
        front = (front+1)%max_size;
        return arr[front];
    }
    public int pop_back(){
        if(rear==front)
            return -1;
        int cur = rear;
        rear = ( rear > 0 ? (rear-1)%max_size : max_size-1);
        return arr[cur];
    }
    public int size(){
        return rear>=front? rear-front : max_size-front+rear;
    }
    public int isEmpty(){
        return rear==front ? 1 : 0;
    }
    public int peek_front(){
        if(rear==front)
            return -1;
        return arr[(front+1)%max_size];
    }
    public void move_left(){
        this.push_back(this.pop_front());
    }
    public void move_right(){
        this.push_front(this.pop_back());
    }
    public int getOptVal(int target) {
        int l_side = goto_left(target);
        int r_side = goto_right(target);
        if (l_side >= r_side) {
            while(this.peek_front() != target)
                this.move_right();
            pop_front();
            return r_side;
        }
        else {
            while(this.peek_front() != target)
                this.move_left();
            pop_front();
            return l_side;
        }
    }
    public int goto_left(int target){
        int cur = rear;
        int cnt = 1;
        while(arr[cur] != target){
            if(cur == 0)
                cur = max_size-1;
            else
                cur= (cur-1)%max_size;
            cnt++;
        }
        return cnt;
    }
    public int goto_right(int target){
        int cur = (front+1)%max_size;
        int cnt = 0;
        while(arr[cur] != target){
            cur = (cur+1)%max_size;
            cnt++;
        }
        return cnt;
    }
}
public class S4_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int target;
        int opt_val = 0;
        st = new StringTokenizer(br.readLine());
        Deck_1021 deck= new Deck_1021(N);
        for(int i = 1 ; i <= N ; i++)
            deck.push_back(i);
        for(int i = 0 ; i < M ; i++){
            target = Integer.parseInt(st.nextToken());
            opt_val += deck.getOptVal(target);
        }
        bw.write(String.valueOf(opt_val));
        bw.flush();
    }
}
