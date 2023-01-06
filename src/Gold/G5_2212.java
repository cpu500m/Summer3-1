// 일단 센서가 설치된 좌표를 받아서 오름차순으로 정렬한 다음에
// 세부 로직을 생각해보는걸로.
// 생각좀 해봤는데 이게
// K가 2다 하면 2개의 영역으로 나눌 수 있는거니까
// 두 영역 사이의 거리를 무시할 수 있는거고.
// K가 5면 5개의 영역으로 나눠지니깐 4개의 영역 사이 거리를 무시할 수 있는거고.
// 그러니깐 그냥 오름차순 정렬한 센서사이 거리 구해서 그 중 값이 가장 큰 K-1개를 제외하면 정답이 나올거같은데? 한번 해봄
// 함 해봄
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int result = 0;
        int cnt = 0;
        // index
        int i;
        int[] sensor = new int[N];
        int[] diff = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(i = 0 ; i < N ; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        // 로직.
        for(i = 0; i < N-1 ; i++){
            diff[i] = sensor[i+1]-sensor[i];
            result+=diff[i];
        }
        Arrays.sort(diff);
        for(i =N-2; i>=0; i--){
            if(cnt == K-1)
                break;
            result-= diff[i];
            cnt++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
