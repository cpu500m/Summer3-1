package Bronze;

import java.io.*;

public class B2_2592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int value , sum = 0;
        int max = 0 , most_freq_val =0;
        int[] count = new int[1000];
        for(int i = 0; i <10 ; i++){
            value = Integer.parseInt(br.readLine());
            count[value]++;
            sum+=value;
        }
        bw.write(String.valueOf(sum/10)+"\n");
        for(int i = 10; i <count.length; i+=10){
            if(count[i] > max){
                most_freq_val =i;
                max = count[i];
            }
        }
        bw.write(String.valueOf(most_freq_val));
        bw.flush();
    }
}
