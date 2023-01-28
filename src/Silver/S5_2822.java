package Silver;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class S5_2822 {
    // 클래스를 생성하여 문제 점수 , 문제 번호를 기록해둔다.
    static class Q{
        int score , num;
        Q(int score ,int num){
            this.score = score;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 총 8문제이므로 8개의 Q 객체를 생성.
        Q[] score = new Q[8];
        // 8번 루프를 돌며 문제의 점수와 문제 번호를 저장하는 모습
        for(int i = 1 ; i <= 8; i++)
            score[i-1] = new Q(Integer.parseInt(br.readLine()), i);
        // Comparator를 사용하여 문제 점수를 기준으로 내림차순 정렬하는 모습
        Arrays.sort(score, new Comparator<Q>() {
            @Override
            public int compare(Q o1, Q o2) {
                return o2.score-o1.score;
            }
        });
        // 문제 번호를 저장해두기 위한 배열
        int[] q_num = new int[5];
        int total = 0;
        // 아까 정렬해둔 배열에서 상위 5항목의 점수를 더하고 , 문제 번호를 기록함.
        for(int i = 0 ; i < 5 ; i++) {
            q_num[i] = score[i].num;
            total += score[i].score;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(total+"\n");
        // 문제 번호 오름차순 정렬
        Arrays.sort(q_num);
        for(int i = 0 ; i < 5 ; i++)
            sb.append(q_num[i]+" ");

        bw.write(sb.toString());
        bw.flush();
    }
}
