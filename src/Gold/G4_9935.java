package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_9935
 * @date : 25. 5. 2.
 */
public class G4_9935 {

    // 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        String target = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if(stack.size() >= target.length()){
                int count = 0;
                for (int j = 0; j < target.length(); j++) {
                    if(stack.get(stack.size()-1-j) == target.charAt(target.length()-1-j)){
                        count++;
                    } else break;

                    if(count == target.length()){
                        while(count > 0){
                            stack.pop();
                            count--;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        if(sb.length() ==0){
            sb.append("FRULA");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
