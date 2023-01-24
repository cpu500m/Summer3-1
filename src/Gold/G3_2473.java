// 흠.. N이 5천
// 그렇다면 O(N^2) 까지는 괜찮음. 물론 계수가 작아야겠지만..
// 좀 오래 생각해봤는데
// 일단 정렬 해두고
// N 번돌면서
// 그 안에서 두 포인터 위치를 옮겨가며 최적일때를 기록해두는거임.
// 그러면 되지 않을까
// 근데이게 셋다 앞에서 출발하니깐 안되고..
// 보니깐 두번쨰 포인트를 앞에
// 세번쪠 포인터를 뒤에 위치시킨 다음에 옮겨가야 할거같음.
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // index
        int i,j,k;
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        /*  로직  */
        // 일단 오름차순 정렬
        Arrays.sort(arr);

        long opt_value = Long.MAX_VALUE;
        int idx1= 0,idx2= 1,idx3= 2;
        long sum;
        // 첫 지점을 고정해 두고 두개를 움직이면서 도는 느낌으로
        for(i = 0 ; i < N-2 ; i++){
            j = i+1;
            k = N-1;
            while (j < k){
                sum = arr[i]+arr[j]+arr[k];
                if(opt_value > Math.abs(sum)){
                    idx1 = i;
                    idx2 = j;
                    idx3 = k;
                    opt_value = Math.abs(sum);
                    if(opt_value == 0)
                        break;
                }
                if(sum > 0)
                    k--;
                else
                    j++;
            }
        }
        System.out.printf("%d %d %d", arr[idx1],arr[idx2],arr[idx3]);
    }
}
