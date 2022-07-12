package Silver;

import java.io.*;
import java.util.StringTokenizer;

class person_info{
    private int weight;
    private int height;
    private int rank;
    person_info(int weight, int height){
        this.weight = weight;
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
public class S5_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int person_count = Integer.parseInt(br.readLine());
        int rank = 1;
        person_info[] person = new person_info[person_count];
        for(int i = 0 ; i <person_count; i++){
            st = new StringTokenizer(br.readLine());
            person[i] = new person_info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i = 0 ; i < person_count; i++){
            rank = 1;
            for(int j = 0 ; j< person_count; j++){
                if( i == j)
                    continue;
                if(person[i].getHeight() < person[j].getHeight() && person[i].getWeight() < person[j].getWeight())
                    rank++;
            }
            person[i].setRank(rank);
        }
        for(int i = 0 ; i< person_count; i++)
            sb.append(person[i].getRank()+" ");
        bw.write(sb.toString());
        bw.flush();
    }
}
