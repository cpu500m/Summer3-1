package Silver;

import java.io.*;

class Max_heap{
    private int[] heap;
    private int cur_size;
    Max_heap(int n){
        heap = new int[n+1];
        cur_size = 0;
    }
    public void push(int val){
        int cur_node = ++cur_size;
        while( cur_node != 1 && heap[cur_node / 2] < val){
            heap[cur_node] = heap[cur_node/2];
            cur_node/=2;
        }
        heap[cur_node] = val;
    }
    public int pop() {
        if (cur_size == 0)
            return 0;
        int result = heap[1];
        if (cur_size == 1){
            cur_size = 0;
            return result;
    }
        int cur_node = 1;
        int temp;
        heap[1] = heap[cur_size--];
        while(cur_node*2 <= cur_size){
            if(cur_node*2+1 > cur_size)
                if(heap[cur_node*2] > heap[cur_node]) {
                    temp = heap[cur_node];
                    heap[cur_node] = heap[cur_node * 2];
                    heap[cur_node*2] = temp;
                }

            if(heap[cur_node*2] >= heap[cur_node*2+1] && heap[cur_node*2] > heap[cur_node]) {
                temp = heap[cur_node];
                heap[cur_node] = heap[cur_node * 2];
                heap[cur_node*2] = temp;
                cur_node*=2;
            }
            else if(heap[cur_node*2+1] > heap[cur_node]){
                temp = heap[cur_node];
                heap[cur_node] = heap[cur_node*2+1];
                heap[cur_node*2+1] = temp;
                cur_node = cur_node*2+1;
            }
            else
                break;
        }
        return result;
    }
}

public class S2_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Max_heap max_heap = new Max_heap(N);
        int command;
        for(int i = 0 ; i < N ;i++){
            command = Integer.parseInt(br.readLine());
            if( command == 0)
                sb.append(max_heap.pop()+"\n");
            else
                max_heap.push(command);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
