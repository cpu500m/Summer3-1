package Bronze;

import java.io.*;

public class B4_5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int min = 2001;
        for(int i = 0 ; i < 3 ; i++){
            int b = Integer.parseInt(br.readLine());
            if(min > b)
                min = b;
        }
        int min2 = 2001;
        for(int i = 0 ; i <2 ; i++) {
            int b = Integer.parseInt(br.readLine());
            if (min2 > b)
                min2 = b;
        }
        bw.write(String.valueOf(min+min2-50));
        bw.flush();
    }
}
