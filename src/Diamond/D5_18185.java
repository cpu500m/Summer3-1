/* 2023-01-02 푼 문제 */
// 최악 4bytes * 10000 + 등등 계산해봤을때 32MB는 절대 안넘을것 같아서 일단 메모리는 OK
// 시간 복잡도는 각각을 하나하나 처리한다면 시간 제한에 걸리겠지만
// 인접한 여러 개 중 최소 갯수 만큼을 일괄처리해준다면 0.5초 내에 무난히 들 것으로 예상.
// 근데 처음 풀이대로 했을 때 틀렸다 나와서 이유를 좀 생각해봤음.
// 3 4 3 2 같은 경우
// 첫 사고대로면 0 1 0 2  -> 0 0 0 0 으로 가는데 이보다는
// 2 3 3 2 -> 0 1 1 2 -> 0 0 0 1 -> 0 0 0 0 이 비용이 적다는걸 깨달음.
// 그래서 첫번째 인접 3개를 검사할 때 조건을 하나 추가하였음.
// 중앙값이 뒤값보다 크다면 그보다 같거나 작게 만들어주는 식으로. 그래서 해결됨.
package Diamond;

import java.io.*;
import java.util.StringTokenizer;

public class D5_18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int min , total = 0 , diff;
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i;
        // 입력처리
        for(i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        // Solution check ( termination condition)
        while(total !=0) {
            // Selection procedure
            for (i = 0; i < n - 2; i++) {
                if (arr[i] != 0 && arr[i + 1] != 0 && arr[i + 2] != 0 ) {
                    if(arr[i+1] > arr[i+2]){
                        diff = arr[i+1] - arr[i+2];
                        if(arr[i] >= diff){
                            arr[i] -= diff;
                            arr[i + 1] -= diff;
                            result += 5*diff;
                            total -= 2*diff;
                        }
                        else{
                            arr[i + 1] -= arr[i];
                            result += 5*arr[i];
                            total -= 2*arr[i];
                            arr[i] = 0;
                        }
                    }
                    min = Math.min(arr[i], arr[i + 1]);
                    min = Math.min(min, arr[i + 2]);
                    result += 7 * min;
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    arr[i + 2] -= min;
                    total -= 3 * min;
                }
            }
            for (i = 0; i < n - 1; i++) {
                if (arr[i] != 0 && arr[i + 1] != 0) {
                    min = Math.min(arr[i], arr[i + 1]);
                    result += 5 * min;
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    total -= 2 * min;
                }
            }
            for (i = 0; i < n ; i++) {
                if (arr[i] != 0) {
                    result += 3 * arr[i];
                    total -= arr[i];
                    arr[i] = 0;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();

    }
}
