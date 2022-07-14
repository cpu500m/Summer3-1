// 근데 풀고나서 다시생각해보니까 그냥
// 이름이 key인 해시맵과 번호가 key인 해시맵 두개 만들어서
// 하면 될듯 굳이 정렬안해도
package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Monster{
    private String name;
    private int num;
    Monster(String name, int num){
        this.name=name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }
}
public class S4_1620 {
    static Monster[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Monster[] monsters = new Monster[N];
         sorted = new Monster[N];
        String name;
        String str;
        for (int i = 0; i < N ; i++) {
            name = br.readLine();
            monsters[i] = new Monster(name, i + 1);
            sorted[i] = new Monster(name,i+1);
        }
        Comparator<Monster> sort = new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Arrays.sort(sorted, sort);
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            if(str.matches("[0-9]*"))
                sb.append(monsters[Integer.parseInt(str)-1].getName()+"\n");
            else{
                sb.append(searchName(str, 0 , N-1)+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
    public static int searchName(String str, int low , int high){
        int mid = (low+high)/2;
        if( str.compareTo(sorted[mid].getName()) < 0)
            return searchName(str, low, mid-1);
        else if( str.compareTo(sorted[mid].getName()) > 0)
            return searchName(str, mid+1,high);
        else
            return sorted[mid].getNum();
    }
}
