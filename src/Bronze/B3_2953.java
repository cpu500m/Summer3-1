package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_2953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0 , id = -1;
        for(int i = 0 ; i <5 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j = 0 ; j <4 ; j++)
                sum+= Integer.parseInt(st.nextToken());
            if(sum > max){
                max = sum;
                id = i+1;
            }
        }
        bw.write(id+" "+max);
        bw.flush();
    }
}
