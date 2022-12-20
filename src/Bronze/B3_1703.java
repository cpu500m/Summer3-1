package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B3_1703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int age , cnt, i;
        StringBuilder sb=  new StringBuilder();
        int[] arr;
        while(st.hasMoreElements()){
            age = Integer.parseInt(st.nextToken());
            if(age == 0)
                break;
            arr = new int[age*2];
            for(i = 0 ; i < 2*age ; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            cnt = arr[0];
            for( i = 1 ; i < 2*age ; i++) {
                if( i %2 == 1){
                    cnt -= arr[i];
                }
                else
                    cnt *=arr[i];
            }
            sb.append(cnt+"\n");
            st = new StringTokenizer(br.readLine());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
