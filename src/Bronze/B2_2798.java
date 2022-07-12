package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        int sum = 0;
        int opt_value=Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < N-2 ; i++){
            sum = 0;
            sum+=arr[i];
            for(int j = i+1 ; j <N-1; j++){
                sum+=arr[j];
                for(int k = j+1; k <N ; k++){
                    sum+=arr[k];
                    if(sum <= M && (opt_value > (M- sum)))
                        opt_value = M-sum ;
                    if(opt_value == 0) {
                        bw.write(String.valueOf(M));
                        bw.flush();
                        return ;
                    }
                    sum-=arr[k];
                }
                sum-=arr[j];
            }
            sum-=arr[i];
        }
        bw.write(String.valueOf(M-opt_value));
        bw.flush();
    }
}
