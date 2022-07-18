package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int max = Math.max(first, second);
        int min = Math.min(first,second);
        int temp;
        // 유클리드 호제법
        while(max % min != 0) {
            temp = min;
            min = max % min;
            max = temp;
        }
        sb.append(min+"\n");
        // 최대공약수 * 최소공약수 = 두 수의 곱
        sb.append(first*second/min);
        bw.write(sb.toString());
        bw.flush();
    }
}
//        for(int i = min ; i > 0 ; i--)
//            if(first % i == 0 && second % i ==0){
//                sb.append(i+"\n");
//                break;
//            }
//        for(int i = max ; i <= first*second; i++)
//            if (i % first == 0 && i % second == 0){
//                sb.append(i);
//                break;
//        }
//        bw.write(sb.toString());
//            bw.flush();
//    }
//}
