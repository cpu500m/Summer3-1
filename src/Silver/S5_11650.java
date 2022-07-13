package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Coordinate implements Comparable<Coordinate>{
    private int x_pos;
    private int y_pos;
    Coordinate(int x_pos, int y_pos){
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public int getX_pos() {
        return x_pos;
    }
    public int getY_pos() {
        return y_pos;
    }
    @Override
    public int compareTo(Coordinate c){
        if( this.getX_pos() == c.getX_pos())
            return this.getY_pos() - c.getY_pos();
        else
            return this.getX_pos() - c.getX_pos();
    }
}
public class S5_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Coordinate[] coordinates = new Coordinate[N];
        String str;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            coordinates[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(coordinates);
        for(int i = 0 ; i <N; i++)
            sb.append(coordinates[i].getX_pos()+" "+coordinates[i].getY_pos()+"\n");
        bw.write(sb.toString());
        bw.flush();

    }
}
