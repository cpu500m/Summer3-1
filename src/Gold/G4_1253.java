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
 * @fileName : G4_1253
 * @date : 2024-06-30
 */
public class G4_1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 입력 처리*/
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        /* 로직 */
        //1. 정렬
        Arrays.sort(arr);

        int result = 0;

        int idx1 = 0;
        int idx2 = 1;
    }
}
