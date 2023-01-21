// n 이 최악 10만이니까
// n*log n 이내의 시간복잡도 알고리즘을 생각해봐야겠지
// 이분 탐색 하면 되지않을까..

package Gold;

import java.io.*;
import java.util.StringTokenizer;

public class G5_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*      입력  처리      */
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr= new int[N];

        // index
        int i;
        for(i = 0 ; i < N ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        /*      로직      */
        int t1=0 , t2=0 , result = Integer.MAX_VALUE;
        int start , end , mid , temp;
        for(i = 0; i < N ; i++){
            start = i+1;
            end = N-1;
            while (start <= end){
                mid = (start+end)/2;
                temp = Math.abs(arr[mid] + arr[i]);
                if( temp < result){
                    t1 = arr[i];
                    t2 = arr[mid];
                    result = temp;
                }
                else if(arr[mid]+arr[i] > 0)
                    end = mid-1;
                else start = mid+1;
            }
            if(result == 0) break;
        }
        bw.write(String.valueOf(t1)+" "+String.valueOf(t2));
        bw.flush();
    }
}
