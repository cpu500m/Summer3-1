/* 2022-06-28*/
package Bronze;

import java.io.*;

public class B2_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String value = String.valueOf(Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())) ;
        int[] count = new int[10];
        int len = value.length();
        for(int i=0; i < len; i++){
            switch (value.charAt(i)){
                case '0' :
                    count[0]++;
                    break;
                case '1' :
                    count[1]++;
                    break;
                case '2' :
                    count[2]++;
                    break;
                case '3' :
                    count[3]++;
                    break;
                case '4' :
                    count[4]++;
                    break;
                case '5' :
                    count[5]++;
                    break;
                case '6' :
                    count[6]++;
                    break;
                case '7' :
                    count[7]++;
                    break;
                case '8' :
                    count[8]++;
                    break;
                case '9' :
                    count[9]++;
                    break;
            }
        }
        for(int i = 0; i< 10; i++)
             sb.append(count[i]+"\n");
        bw.write(sb.toString());
        bw.flush();
    }

}
