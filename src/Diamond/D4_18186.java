// 18185번이랑 매우 유사한데
// B랑 C값을 비교해서 낱개구매가 더싸면 낱개로 사고
// 계산 시 32bits 범위를 넘어갈 수 있으니깐 자료형을 64bits 자료형 써주는 그정도 차이?..
package Diamond;

import java.io.*;
import java.util.StringTokenizer;

public class D4_18186 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long min , total = 0 , diff;
        long result = 0;
        st = new StringTokenizer(br.readLine());
        int i;
        // 입력처리
        for(i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        if(b <= c){
            result += b*total;
            total = 0;
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
                            result += (b+c)*diff;
                            total -= 2*diff;
                        }
                        else{
                            arr[i + 1] -= arr[i];
                            result += (b+c)*arr[i];
                            total -= 2*arr[i];
                            arr[i] = 0;
                        }
                    }
                    min = Math.min(arr[i], arr[i + 1]);
                    min = Math.min(min, arr[i + 2]);
                    result += (b+2*c) * min;
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    arr[i + 2] -= min;
                    total -= 3 * min;
                }
            }
            for (i = 0; i < n - 1; i++) {
                if (arr[i] != 0 && arr[i + 1] != 0) {
                    min = Math.min(arr[i], arr[i + 1]);
                    result += (b+c) * min;
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    total -= 2 * min;
                }
            }
            for (i = 0; i < n ; i++) {
                if (arr[i] != 0) {
                    result += b * arr[i];
                    total -= arr[i];
                    arr[i] = 0;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();

    }
}
