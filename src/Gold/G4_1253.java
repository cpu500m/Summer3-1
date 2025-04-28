package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_1253
 * @date : 2024-06-30
 */
public class G4_1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리*/
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* 로직 */
        //1. 정렬
        Arrays.sort(arr);

        // 좋은 수의 개수
        int result = 0;

        for(int i = 2 ; i < n ; i++){
            int end = i-1;
            while(end+2 < n && arr[end+1] == arr[end+2]){
                end++;
            }
            if(twoPointer(0,end , arr[i] , arr)){
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static boolean twoPointer(int left, int right, int target ,int[] arr){
        while(left < right){
            if(arr[left]+arr[right] == target){
                return true;
            }
            else if(arr[left]+arr[right] < target){
                left++;
            } else{
                right--;
            }
        }
        return false;
    }
}
