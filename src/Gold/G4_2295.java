package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_2295
 * @date : 25. 5. 1.
 */
public class G4_2295 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sumArr = new int[n*(n+1)/2];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /* 로직 */
        // x + y + z = k 니깐  x + y = k - z
        // 가운데서 만나기인가.. 그거 쓰면 될듯
        int curIdx = 0;
        for(int i = 0; i < n; i++){
            for(int j= i; j < n ; j++){
                sumArr[curIdx++] = arr[i] + arr[j];
            }
        }

        // 이분탐색을 위해 정렬
        Arrays.sort(arr);
        Arrays.sort(sumArr);

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int target = arr[i] - arr[j];
                int left = 0;
                int right = sumArr.length;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if(sumArr[mid] < target) left = mid+1;
                    else right = mid;
                }
                if(target == sumArr[left] && answer < sumArr[left] + arr[j]) {
                    answer = sumArr[left] + arr[j];
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
