package Silver;

import java.io.*;

class Stack_9812{
    private int cur = -1;
    private char[] arr = new char[50];
    public boolean push(char c){
        if( c == '(')
            arr[++cur] = c;
        else if ( c== ')'){
            if(cur == -1)
                return false;
            cur--;
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
public class S4_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        int T = Integer.parseInt(br.readLine());
        boolean check;
        Stack_9812 stack = new Stack_9812();
        for(int i = 0 ; i < T ; i++){
            str = br.readLine();
            check = true;
            for(int j = 0 ; j < str.length() ; j++){
                if(!stack.push(str.charAt(j))){
                    sb.append("NO\n");
                    check =false;
                    break;
                }
            }
            if(stack.getCur() != -1)
                sb.append("NO\n");
            else if(check)
                sb.append("YES\n");
            stack.clear();
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
