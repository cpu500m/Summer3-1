// A가 1 ,2 ,4
// B가 2 , 3, 4 , 5 ,6 인 경우
// A 가 true이고 B가 False이면 count++
// B가 true이고 A가 False이면 count++
// 을 생각했는데 -1억~ +1억 범위라서 400MB정도가 잡히니 메모리 제한에 어긋남.
// 그래서 그냥 배열에 저장해야될거가틈.
// 각각 정렬한다음에 A부터 기준잡고 A>B면 B의 다음거 가리키게 넘기고. A == B면 count 하나빼고
// A <B 면 A의 다음거 가리키게 하고
// 이런 방식을 생각해보면 최악의 경우 (400,000번루프 * 최악의 경우 if문 3번 ) * (B도해야하니까 2) = 240만번의 연산
// 괜찮을것 같음. 이대로 진행.
package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A_size = Integer.parseInt(st.nextToken());
        int B_size = Integer.parseInt(st.nextToken());
        int[] A = new int[A_size];
        int[] B = new int[B_size];
        int a_count = A_size;
        int b_count = B_size;
        int a_cur = 0 , b_cur = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < A_size; i++)
            A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < B_size ; i++)
            B[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        Arrays.sort(B);
        while(a_cur < A_size && b_cur <B_size){
            if(A[a_cur] == B[b_cur]){
                a_count--;
                a_cur++;
                b_cur++;
            }
            else if(A[a_cur] < B[b_cur]){
                a_cur++;
            }
            else if(A[a_cur] > B[b_cur])
                b_cur++;
        }
        a_cur=0;
        b_cur=0;
        while(a_cur < A_size && b_cur <B_size){
            if(B[b_cur] == A[a_cur]){
                b_count--;
                a_cur++;
                b_cur++;
            }
            else if(B[b_cur] < A[a_cur]){
                b_cur++;
            }
            else if(B[b_cur] > A[a_cur])
                a_cur++;
        }
        bw.write(String.valueOf(a_count+b_count));
        bw.flush();
    }
}
