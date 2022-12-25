package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G4_1083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine()) , cnt , sorted_idx = 0;
        int[] arr = new int[size];
        int i , j;
        boolean termination = false;
        int temp , max , max_idx = -1;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(i = 0 ; i<size; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(br.readLine());
        while(cnt > 0 && termination == false) {
            termination = true;
            max = -1;
            for (i =sorted_idx; i <= sorted_idx+cnt; i++) {
                if( i == size)
                    break;
                if(max < arr[i]) {
                    max = arr[i];
                    max_idx = i;
                    termination = false;
                }
            }
            cnt -= max_idx-sorted_idx;
            for( i = max_idx; i > sorted_idx ; i--){
                temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
            sorted_idx++;
        }
        for(i = 0 ; i <size ; i++)
            sb.append(arr[i]+" ");
        bw.write(sb.toString());
        bw.flush();
    }
}
