package Silver;

import java.io.*;
import java.util.StringTokenizer;

class Deck_10866{
    private int front;
    private int rear;
    private int[] arr;
    private int max_size;
    Deck_10866(int size){
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
    public int peek_back(){
        if(rear==front)
            return -1;
        return arr[rear];
    }
}
public class S4_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        String str;
        StringBuilder sb = new StringBuilder();
        Deck_10866 deck = new Deck_10866(N);
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            if (str.equals("push_front"))
                deck.push_front(Integer.parseInt(st.nextToken()));
            else if (str.equals("push_back"))
                deck.push_back(Integer.parseInt(st.nextToken()));
            else if (str.equals("pop_front"))
                sb.append(deck.pop_front() + "\n");
            else if (str.equals("pop_back"))
                sb.append(deck.pop_back() + "\n");
            else if (str.equals("size"))
                sb.append(deck.size() + "\n");
            else if (str.equals("empty"))
                sb.append(deck.isEmpty() + "\n");
            else if (str.equals("front"))
                sb.append(deck.peek_front() + "\n");
            else if (str.equals("back"))
                sb.append(deck.peek_back() + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        }
}
