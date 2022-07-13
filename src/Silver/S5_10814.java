package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Person implements Comparable<Person>{
    private int age;
    private String name;
    private int order;
    Person(int age, String name , int order){
        this.age = age;
        this.name = name;
        this.order = order;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public int compareTo(Person p){
        if( this.getAge() == p.getAge())
            return this.getOrder() - p.getOrder();
        else
            return this.getAge() - p.getAge();
    }
}

public class S5_10814{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        String str;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken() , i);
        }
        Arrays.sort(people);
        for(int i = 0 ; i <N; i++)
            sb.append(people[i].getAge()+" "+people[i].getName()+"\n");
        bw.write(sb.toString());
        bw.flush();

    }
}
