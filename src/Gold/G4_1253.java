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
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /* 로직 */
        // 1. 오름차순 정렬
        Arrays.sort(arr);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            if(left == i) left++;
            int right = left+1;
            if(right == i) right++;

            int target = arr[i];

            boolean isRightAtEnd = false;
            while (left < right && right < arr.length) {
                if(right == i){
                    if(isRightAtEnd || right == arr.length-1) {
                        right--;
                        isRightAtEnd = true;
                    }
                    else right++;
                    continue;
                }
                if(left == i){
                    left++;
                    continue;
                }
                int sum = arr[left] + arr[right];
                if(sum < target) {
                    if(isRightAtEnd) {
                        left++;
                    }else {
                        if(right == arr.length-1){
                            isRightAtEnd = true;
                        }else {
                            right++;
                        }
                    }
                } else if(sum > target){
                    isRightAtEnd = true;
                    right--;
                } else{
                    answer++;
                    break;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
