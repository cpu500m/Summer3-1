package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S5_5635 {
    static class Person{
        String name;
        int year, month , day;
        Person(String name , int day , int month , int year){
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(st.nextToken(),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // 나이 적은애 앞에오게 그니깐 오름차순으로
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.year == o2.year){
                    if(o1.month == o2.month)
                        return o2.day - o1.day;
                    return o2.month - o1.month;
                }
                return o2.year- o1.year;
            }
        });
        bw.write(people[0].name+"\n"+people[N-1].name);
        bw.flush();
    }
}
