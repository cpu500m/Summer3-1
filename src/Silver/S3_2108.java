package Silver;

import java.io.*;
import java.util.Arrays;

public class S3_2108 {
    private static int SIZE = 8001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int cur_value;
        int sum=0;
        int most_frequent = 0 ;
        int most_frequent_value = 0;
        int repeat=1;
        int[] count = new int[SIZE];
        int loop_count = Integer.parseInt(br.readLine());
        int[] arr = new int[loop_count];
        for(int i = 0 ; i < loop_count; i++){
            cur_value = Integer.parseInt(br.readLine());
            sum+=cur_value;
            arr[i] = cur_value;
            if(cur_value > max)
                max = cur_value;
            if(cur_value < min)
                min = cur_value;
            count[cur_value+4000]++;
        }
        Arrays.sort(arr);
        sb.append( Math.round((double)sum/loop_count)+"\n");
        sb.append(arr[(loop_count-1)/2]+"\n");
        for(int i = 0 ; i < SIZE ; i++){
            if(most_frequent == count[i]){
                repeat++;
                if(repeat == 2) {
                    most_frequent_value = i-4000;
                }
            }
            else if(most_frequent < count[i]){
                most_frequent= count[i];
                most_frequent_value = i-4000;
                repeat=1;
            }
        }
        sb.append(most_frequent_value+"\n");
        sb.append((max-min)+"\n");
        bw.write(sb.toString());
        bw.flush();
    }
}
