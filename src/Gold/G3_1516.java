// 위상정렬 하면댈듯
package Gold;

import java.io.*;
import java.util.*;

public class G3_1516 {
    static class Structure{
        int time;
        int in_degree;
        int delay;
        List<Integer> arrayList;

        Structure() {
            time = 0;
            in_degree = 0;
            delay = 0;
            arrayList = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Structure[] structures = new Structure[N+1];

        // 출력
        StringBuilder sb = new StringBuilder();
        Queue<Structure> queue = new LinkedList<>();

        // 건물 객체 생성
        for (int i = 1; i <=  N; i++) {
            structures[i] = new Structure();
        }

        // 입력 처리
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            structures[i].time += Integer.parseInt(st.nextToken());
            int token;
            while ((token = Integer.parseInt(st.nextToken())) != -1) {
                structures[token].arrayList.add(i);
                structures[i].in_degree++;
            }
            if(structures[i].in_degree == 0)
                queue.add(structures[i]);
        }

        // 싹 갱신
        while (!queue.isEmpty()) {
            Structure structure = queue.poll();
            for (int s : structure.arrayList) {
                structures[s].in_degree--;
                if(structures[s].delay < structure.time)
                    structures[s].delay = structure.time;
                if(structures[s].in_degree == 0) {
                    if(structures[s].delay > structure.time)
                        structures[s].time += structures[s].delay;
                    else structures[s].time += structure.time;
                    queue.add(structures[s]);
                }
            }
        }

        //출력
        for (int i = 1; i <=  N; i++) {
            sb.append(structures[i].time+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
