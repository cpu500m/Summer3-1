// A,B,C는 3에 . D,E,F는 4에 ...  W,X,Y,Z는 10에 대응
package Bronze;

import java.io.*;

public class B2_5622 {
    private static int SIZE = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t=0;
        int[] count = new int[SIZE];
        String str = br.readLine();
        for(int i= 0 ; i <str.length();i++){
            if(str.charAt(i)== 'Z') {
                count[7]++;
                continue;
            }
            if(str.charAt(i)-'A' > 17){
                count[(str.charAt(i)-'B')/3]++;
            }
            else
                count[(str.charAt(i)-'A')/3]++;
        }
        for(int i = 0 ; i <SIZE ; i++){
            t+=(i+3)*count[i];
        }
        bw.write(String.valueOf(t));
        bw.flush();
    }
}
