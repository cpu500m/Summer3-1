// KMP
package Gold;

import java.io.*;
import java.util.Arrays;

public class G3_1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int max = 0;
        for(int i = 0 ; i < str.length() ; i++){
            int ret = search(str.substring(i,str.length()));
            if( max < ret)
                max = ret;
        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
    public static int search(String str){
        int max = 0;
        int[] table = new int[str.length()];
        Arrays.fill(table, 0);
        int j = 0 ;
        for (int i = 1; i < str.length(); i++) {
            while (j > 0 && str.charAt(j) != str.charAt(i))
                j = table[j - 1];
            if (str.charAt(i) == str.charAt(j)) {
                table[i] = ++j;
                if (table[i] > max)
                    max = table[i];
            }
        }
        return max;
    }
}
