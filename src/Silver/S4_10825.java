package Silver;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4_10825 {
    static class Person {
        String name;
        int kr;
        int eng;
        int math;

        public Person(String name, int kr, int eng, int math) {
            this.name = name;
            this.kr = kr;
            this.math = math;
            this.eng = eng;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Person> pQueue = constructQueue();

        initQueue(br, pQueue, n);

        printResult(n, pQueue);

    }

    private static void printResult(int n, Queue<Person> pQueue) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(pQueue.poll().name + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void initQueue(BufferedReader br, Queue<Person> pQueue, int n) throws IOException {
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pQueue.add(new Person(st.nextToken(),Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    private static Queue<Person> constructQueue() {
        Queue<Person> pQueue = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.kr == o2.kr){
                    if(o1.eng == o2.eng){
                        if(o1.math == o2.math)
                            return o1.name.compareTo(o2.name);
                        return o2.math - o1.math;
                    }
                    return o1.eng - o2.eng;
                }
                return o2.kr - o1.kr;
            }
        });
        return pQueue;
    }
}
