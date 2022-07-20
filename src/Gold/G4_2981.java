// 가장 단순한 생각은 2부터 들어온 가장 큰수까지
// 루프를 돌리면서 조건에 맞는 수를 하나하나 출력하는건데,
// 이렇게 하면 당연히 시간초과에 걸리니까 다른 방법을 생각 해봄.
// 들어온 수를 a라 하고 M으로 나눴을때의 나머지를 k 라고 하면
// a % M = k  이를 재전개 하면 a - (a / M ) * M = k
// 들어온 수를 arr라는 배열에 차곡차곡 넣는다고 생각하면
// arr[0] - ( arr[0] / M) * M = k
// arr[1] - ( arr[1] / M) * M = k
// ....
// 재전개하면 arr[1] - arr[0] = M*(arr[1]/M - arr[0]/M)
// 여기서부터는 도저히 모르겠어서 인터넷에 찾아봤음.
// 배열을 오름차순으로 정렬하고
// 쭉 전개하면 arr[n] - arr[n-1] = M*(arr[n]/M - arr[n-1]/M)
// 그러면 결국 인접한 두 항을 빼면 M*Xn 꼴이 됨.
// 즉 , 인접한 두 항을 뺀 값들의 최대공약수를 구하면 그 값이 M의 베이스 값이 됨.
// 최대 공약수를 구하고. 그 수의 1을 제외한 약수들을 모두 출력하면 M이 될듯.
package Gold;

import java.io.*;
import java.util.Arrays;
import java.util.Vector;

public class G4_2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();
        int arr_size = Integer.parseInt(br.readLine());
        int M;
        int[] input = new int[arr_size];
        int[] input_diff = new int[arr_size-1];
        Vector<Integer> vector = new Vector<>();
        for(int i = 0 ; i < arr_size ; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);
        for(int i = 0; i < input_diff.length ; i++)
            input_diff[i] = input[i+1]-input[i];

        if(input_diff.length == 1){
            M = input_diff[0];
            for(int i = 2 ; i*i<=M ; i++){
                if(M % i ==0) {
                    vector.add(i);
                    if( M / i != i)
                        vector.add(M/i);
                }
            }
            vector.add(M);
            Object[] result = vector.toArray();
            Arrays.sort(result);
            for (int i = 0; i < result.length; i++)
                sb.append(result[i] + " ");
            bw.write(sb.toString());
            bw.flush();
            return;
        }
           M = euclidean(input_diff[1],input_diff[0]);

        for(int i = 2 ; i< input_diff.length; i++){
            M = euclidean(input_diff[i], M);
        }
        for(int i = 2 ; i*i<=M ; i++){
            if(M % i ==0) {
                vector.add(i);
                if( M / i != i)
                    vector.add(M/i);
            }
        }
        vector.add(M);
        Object[] result = vector.toArray();
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++)
            sb.append(result[i] + " ");
        bw.write(sb.toString());
        bw.flush();
    }
    public static int euclidean(int a, int b){
        int temp;
        int A= a, B= b;
        while (A % B != 0){
            temp = B;
            B = A % B;
            A = temp;
        }
        return B;
    }
}
