package Bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] input = new int[3];
        for(int i = 0 ; i < input.length ; i++)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        while( input[0] != 0 && input[1] != 0 &&  input[2] != 0 ){
            if(input[0]*input[0]+ input[1]*input[1] == input[2]*input[2]){
                sb.append("right\n");
            }
            else{
                sb.append("wrong\n");
            }
            st= new StringTokenizer(br.readLine());
            for(int i = 0 ; i < input.length ; i++)
                input[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(input);
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
