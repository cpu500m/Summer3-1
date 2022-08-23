package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Queue_1966{
    private int front;
    private int rear;
    private int[] arr;
    private int[] importance_arr;
    private int max_size;

    Queue_1966(int size){
        front = 0;
        rear = 0;
        importance_arr = new int[size+1];
        max_size = size+1;
        arr = new int[size+1];
    }
    public void push(int i, int importance){
        rear = (rear+1)%max_size;
        arr[rear] = i;
        importance_arr[rear] = importance;
    }
    public int[] pop(){
        int[] ret = new int[2];
        front = (front+1)%max_size;
        ret[0]= arr[front]; ret[1]= importance_arr[front];
        return ret;
    }
    public int getMax_size() {
        return max_size;
    }
    public boolean isEmpty(){
        return rear ==front;
    }
    public int peek(){
        return importance_arr[(front+1)%max_size];
    }
}

public class S3_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int target, cnt , imp_idx;
        int[] ret = new int[2];
        Integer[] imp;
        Queue_1966 queue;
        for(int i = 0 ; i < loop_count ; i++){
            st = new StringTokenizer(br.readLine());
            queue = new Queue_1966(Integer.parseInt(st.nextToken()));
            target = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            imp = new Integer[queue.getMax_size()-1];
            imp_idx =0;
            cnt =1;
            for(int j = 0 ; j < queue.getMax_size()-1 ;j++){
                imp[j] = Integer.parseInt(st.nextToken());
                queue.push(j,imp[j]);
            }
            Arrays.sort(imp, Collections.reverseOrder());
            while(!queue.isEmpty()){
                while(queue.peek() < imp[imp_idx]) {
                    ret = queue.pop();
                    queue.push(ret[0],ret[1]);
                }
                if(queue.pop()[0] == target)
                    break;
                imp_idx++;
                cnt++;
            }
            sb.append(cnt+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
