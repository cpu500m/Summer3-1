// 설계한 로직은 아래와 같다.
// 1. 문자는 그냥 출력해라
// 2. operator의 경우는 우선순위에 맞게 출력 또는 스택에 쌓는다.
// 2번 우선순위 규칙
// (1) *, /
// (2) + , -
// (3) ( , )
// 이 때, ( 가 등장하는 경우는 (를 그냥 스택에 쌓고,  이전 operator가 ( 인 경우에는 3번 우선순위로 간주한다.
// ) 가 나왔을 경우에는 , ( 가 등장할때 까지 연산자 스택을 비운다.

package Gold;

import java.io.*;
import java.util.Stack;

public class G2_1918 {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String expression = br.readLine();

        Stack<Character> operator_stack = new Stack<>();

        for(int i = 0 ; i < expression.length() ; i++){
            // 1 . 문자인 경우. 그냥 출력한다
            char c = expression.charAt(i);
            if( 0 <= c - 'A' && c-'Z' <= 0) {
                sb.append(c);
                continue;
            }
            // 2. 연산자의 경우. 위에 써둔 로직에 해당하는 동작을 수행한다.
            parse_op(c,operator_stack);
        }
        // 3. expression 길이만큼 루프를 돌았다면 , 이제 stack을 비워준다.
        while (!operator_stack.isEmpty()){
            sb.append(operator_stack.pop());
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void parse_op(char c , Stack<Character> stack){
        // 곱하기나 나누기의 경우. 이전에 스택에 무엇이 있던 일단 집어넣고 본다.
        // 아니지 우선순위 같은애면은 비워야지 ㅎㅎ;
        if(c == '*' || c == '/' ){
            while (!stack.isEmpty() && ( stack.peek() == '*' || stack.peek() == '/' ))
                sb.append(stack.pop());
            stack.push(c);
            return ;
        }
        // 2번째 우선순위. 이전에 스택에 '('이 있는경우 또는 스택이 빈경우 까지 그대로 출력한다.
        else if(c == '+' || c == '-') {
            while (!stack.isEmpty() && stack.peek() != '(')
                sb.append(stack.pop());
            stack.push(c);
            return ;
        }
        else if(c == '('){
            stack.push(c);
            return ;
        }
        // 닫는 괄호는 여는 괄호까지 정리해주어야 한다.
        else if(c == ')'){
            while (stack.peek() != '(')
                sb.append(stack.pop());
            stack.pop();
            return ;
        }

    }
}
