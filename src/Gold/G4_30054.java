package Gold;

import java.io.*;
import java.util.*;

public class G4_30054 {
    static class Person{
        int wait_time = 0;
        int reserve_time;
        int arrive_time;
        boolean check = false;

        Person(int reserve_time, int arrive_time){
            this.reserve_time = reserve_time;
            this.arrive_time = arrive_time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Person> queue = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.arrive_time == o2.arrive_time)
                    return o1.reserve_time - o2.reserve_time;
                return o1.arrive_time - o2.arrive_time;
            }
        });

        /* process input */
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        Map<Integer, Person> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            queue.add(people[i]);
            map.put(people[i].reserve_time, people[i]);
        }

        /* logic */
        updateWaitTime(queue,map);
        int result = solution(n, people);

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void updateWaitTime(PriorityQueue<Person> queue, Map<Integer,Person> map) {
        // 시뮬레이션
        int cur_time = 0;
        while (!queue.isEmpty()) {
            if(queue.peek().check){
                queue.poll();
                continue;
            }
            cur_time++;
            // 가장 빠른 예약이 현재 시간보다 뒤라면 쉰다.
            if (queue.peek().arrive_time > cur_time) continue;

            // 큐가 만약 예약 시간 전에 온 손님을 갖고있다면 먼저 처리한다.
            Person rv_p = map.get(cur_time);
            if (rv_p != null && !rv_p.check && rv_p.arrive_time <= cur_time) {
                rv_p.wait_time = cur_time - rv_p.arrive_time;
                rv_p.check = true;
                continue;
            }
            Person cur = queue.poll();
            cur.check = true;
            cur.wait_time = (cur_time - cur.arrive_time);
        }
    }

    private static int solution(int n, Person[] people) {
        int result =0;
        for (int i = 0; i < n; i++) {
            if(people[i].wait_time > result)
                result = people[i].wait_time;
        }
        return result;
    }
}
