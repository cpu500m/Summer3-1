/* 2022-07-04 */
package Silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class S5_4673 {
    static boolean[] check = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        checkSelfNumber();
        for(int i = 1; i < check.length; i++){
            if(!check[i]){
                sb.append(i+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static void checkSelfNumber(){
        int sum=0;
        String str;
        for(int i =1; i < check.length; i++){
            str = String.valueOf(i);
            for(int j = 0; j < str.length(); j++){
                sum+=Character.getNumericValue(str.charAt(j));
            }
            sum+=i;
            if(sum < 10001) {
                check[sum] = true;
            }
            sum=0;
        }
    }
}
