package Bronze;

import java.io.*;
import java.util.Arrays;

public class B1_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] arr  = new int[9];
        int diff = 0;
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            diff+=arr[i];
        }
        Arrays.sort(arr);
        diff -= 100;
        for(int i = 0; i < arr.length -1 ; i++){
            for(int j = i+1 ; j < arr.length ;j++){
                if(arr[i]+arr[j] == diff){
                    for(int k = 0 ; k < arr.length ; k++){
                        if( k != i && k != j)
                            sb.append(arr[k]+"\n");
                    }
                    bw.write(sb.toString());
                    bw.flush();
                    return ;
                }
            }
        }
    }
}
