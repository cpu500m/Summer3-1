package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_17609
 * @date : 25. 4. 27.
 */
public class G5_17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        //todo 재귀 형태로 다시 해보기
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int result = isPalindrome(0, str.length() - 1, str, 0);
            sb.append(result+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    public static int isPalindrome(int l , int r, String str, int cnt){
        while(l < r){
            if(str.charAt(l) != str.charAt(r)){
                if(cnt == 0){
                    if(isPalindrome(l+1,r,str,cnt+1) == 0|| isPalindrome(l,r-1,str,cnt+1) == 0) return 1;
                    return 2;
                }
                return 2;
                }
            l++;
            r--;
        }
        return 0;
    }
}
