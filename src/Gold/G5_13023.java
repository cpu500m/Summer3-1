package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G5_13023
 * @date : 25. 4. 29.
 */

//todo 내일 다시 하셈 이거만 풀고 자
public class G5_13023 {

    static class Person {
        int idx;
        boolean isVisited = false;
        List<Person> friendList = new ArrayList<>();

        Person(int idx) {
            this.idx = idx;
        }
    }

    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Person[] people = new Person[N];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            people[p1].friendList.add(people[p2]);
            people[p2].friendList.add(people[p1]);
        }

        /* 로직 */
        // 최외각 N명에 대한 루프를 돌면서 친구가 5명있는지 여부를 따진다.

        for(int i = 0; i < N; i++) {
            int depth = 1;
            people[i].isVisited = true;

            backTracking(depth,i,people);

            people[i].isVisited = false;
        }

        /* 출력 */
        bw.write(String.valueOf(answer));
        bw.flush();
    }

    private static void backTracking(int depth, int idx, Person[] people) {
        if(depth == 5 || answer == 1) {
            answer = 1;
            return;
        }

        for (Person person : people[idx].friendList) {
            // 아직 방문하지 않았다면
            if(!person.isVisited) {
                person.isVisited = true;

                backTracking(depth+1,person.idx,people);

                person.isVisited = false;
            }
        }
    }
}
