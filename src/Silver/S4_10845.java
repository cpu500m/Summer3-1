package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S4_10845 {
    static class MyQueue{
        int idx = -1;
        ArrayList<Integer> arr = new ArrayList<>();
        void push(int n){
            arr.add(n);
            idx++;
        }
        int front(){
            if(idx == -1)
                return -1;
            return arr.get(0);
        }

        int pop(){
            if(idx == -1)
                return -1;
            idx--;
            return arr.remove(0);
        }

        int size(){
            return arr.size();
        }

        int empty(){
            if(idx == -1) return 1;
            else return 0;
        }
        int back(){
            if(idx == -1) return -1;
            return arr.get(idx);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        MyQueue queue = new MyQueue();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                queue.push(num);
            } else if (command.equals("pop")) {
                sb.append(queue.pop() + "\n");
            } else if (command.equals("size")) {
                sb.append(queue.size() + "\n");
            } else if (command.equals("empty")) {
                sb.append(queue.empty() + "\n");
            } else if (command.equals("front")) {
                sb.append(queue.front() + "\n");
            } else if(command.equals("back")) {
                sb.append(queue.back() + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
