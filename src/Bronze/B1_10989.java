/* 2022-06-28 */
// 아래 주석 처리한 방식보다 위에 방식이 더 빠르게 동작.
// 그 이유는 arr의 내용을 여러번 돌아가면서 출력하는 것은
// 매 반복마다 그에 해당하는 문자를 생성한후 연결짓고 출력해주는건데
// 스트링 빌더를 이용하면
// 스트링 빌더 내부에 (같은 주소 공간에) 값을 첨부하는 방식이므로 위 방식이 더 빠르다.
package Bronze;

import java.io.*;
import java.util.Arrays;

public class B1_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        for (int i = 0; i < size; i++)
            sb.append(arr[i]).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int size = Integer.parseInt(br.readLine());
//        int[] arr = new int[size];
//        for(int i = 0; i<size; i++)
//            arr[i]=Integer.parseInt(br.readLine());
//        Arrays.sort(arr);
//        for(int i = 0; i< size; i++)
//        bw.write(String.valueOf(arr[i])+"\n");
//        bw.flush();
//    }
//}
