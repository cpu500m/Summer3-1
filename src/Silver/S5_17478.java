package Silver;

import java.io.*;

public class S5_17478 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        printText(n, 0);
        bw.flush();
    }
    public static void printText(int n, int iteration_count) throws IOException {
        if( iteration_count ==0)
            bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        if( n == 0){
            printUnderBar(iteration_count);
            bw.write("\"재귀함수가 뭔가요?\"\n");
            printUnderBar(iteration_count);
            bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            printUnderBar(iteration_count);
            bw.write("라고 답변하였지.\n");
            return ;
        }
        printUnderBar(iteration_count);
        bw.write("\"재귀함수가 뭔가요?\"\n");
        printUnderBar(iteration_count);
        bw.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        printUnderBar(iteration_count);
        bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        printUnderBar(iteration_count);
        bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        printText(n-1, iteration_count+1);
        printUnderBar(iteration_count);
        bw.write("라고 답변하였지.\n");
    }
    public static void printUnderBar(int iteration_count) throws IOException {
        for(int i = 0 ; i < iteration_count; i++)
        bw.write("____");
    }
}
