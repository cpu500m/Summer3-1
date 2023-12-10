package Silver;

import java.io.*;
import java.util.Stack;

public class S4_3986 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char cur = str.charAt(j);
                if (!stack.isEmpty()) {
                    if(stack.peek() == cur) {
                        stack.pop();
                        continue;
                    }
                }
                stack.push(cur);
            }
            if(stack.isEmpty())
                res++;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
