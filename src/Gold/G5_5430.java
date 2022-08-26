package Gold;

import java.io.*;

class Deck_5430{
    static int MODE_FOR = 0;
    static int MODE_REV = 1;
    private int front;
    private int rear;
    private int[] arr;
    private int max_size;
    private int mode;
    Deck_5430(int size){
        front = 0;
        rear = 0;
        max_size = size+1;
        arr = new int[size+1];
        mode = MODE_FOR;
    }
    public void push(int n){
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
    public int getMode() {
        return mode;
    }
    public void change_mode(){
        if(mode == MODE_FOR)
            mode = MODE_REV;
        else mode = MODE_FOR;
    }
}
public class G5_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        String command , input;
        String[] spt_input;
        int size;
        boolean flag;
        Deck_5430 deck;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < loop_count ; i++){
            command = br.readLine();
            size = Integer.parseInt(br.readLine());
            input = br.readLine();
            flag = true;
            spt_input = input.split("]|,|\\[");
            deck = new Deck_5430(size);
            for(int j = 1 ; j < size+1 ; j++) {
                deck.push(Integer.parseInt(spt_input[j]));
            }
            for(int j = 0; j < command.length(); j++){
                if(command.charAt(j) =='R'){
                    deck.change_mode();
                }
                else if(command.charAt(j) =='D'){
                    if(deck.getMode() == Deck_5430.MODE_FOR){
                        if(deck.pop_front() ==-1){
                            sb.append("error\n");
                            flag=false;
                            break;
                        }
                    }
                    else{
                        if(deck.pop_back() == -1){
                            sb.append("error\n");
                            flag =false;
                            break;
                        }
                    }
                }
            }
            if(flag){
                sb.append("[");
                while(deck.size() > 1) {
                    if (deck.getMode() == Deck_5430.MODE_FOR) {
                        sb.append(deck.pop_front()+",");
                    }
                    else
                        sb.append(deck.pop_back()+",");
                }
                if(deck.isEmpty() != 1)
                    sb.append(deck.pop_front());
                sb.append("]\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
