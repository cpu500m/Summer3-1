package Silver;

import java.io.*;

class Stack_4949{
    private int cur = -1;
    private char[] arr = new char[100];
    public boolean push(char c) {
        if (c == '(')
            arr[++cur] = c;
        else if (c == '[')
            arr[++cur] = c;
        else if(c == ')'){
            if(cur == -1)
                return false;
            if( arr[cur--] != '(')
                return false;
        }
        else if(c == ']'){
            if(cur == -1)
                return false;
            if(arr[cur--] != '[')
                return false;
        }
        return true;
    }

    public void clear(){
        cur = -1;
    }

    public int getCur() {
        return cur;
    }
}
public class S4_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        StringBuilder sb= new StringBuilder();
        Stack_4949 stack = new Stack_4949();
        str = br.readLine();
        boolean flag;
        while(str.compareTo(".") != 0){
            flag = true;
            for(int j = 0 ; j < str.length(); j++){
                if(!stack.push(str.charAt(j))) {
                    flag = false;
                    sb.append("no\n");
                    break;
                }
            }
            if(stack.getCur() != -1 && flag)
                sb.append("no\n");
            else if(flag)
                sb.append("yes\n");
            str = br.readLine();
            stack.clear();
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
