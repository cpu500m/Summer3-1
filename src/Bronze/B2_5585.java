package Bronze;

import java.io.*;

public class B2_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int change = 1000 -Integer.parseInt(br.readLine());
        int result = 0;
        while(change > 0){
            if(change >= 500){
                change -= 500;
                result++;
            }
            else if(change >= 100){
                change -= 100;
                result++;
            }
            else if(change >= 50){
                change -= 50;
                result++;
            }
            else if(change >= 10){
                result += change/10;
                change -= change/10 * 10 ;
            }
            else if(change >= 5){
                result += change/5;
                change -= change/5 * 5 ;
            }
            else{
                result += change;
                change = 0;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
