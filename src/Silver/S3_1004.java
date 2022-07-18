package Silver;

import java.io.*;
import java.util.StringTokenizer;

class P{
    private int x_pos;
    private int y_pos;
    P(int x_pos,int y_pos){
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }
}
public class S3_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int loop_count = Integer.parseInt(br.readLine());
        P starting_point;
        P destination;
        int planet_count;
        int diff_x , diff_y, radius;
        int count;
        int start_equation, dest_equation;
        for(int a = 0 ; a < loop_count ; a++){
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            starting_point = new P(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            destination = new P(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            planet_count = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < planet_count ;i++){
                st = new StringTokenizer(br.readLine());
                diff_x = Integer.parseInt(st.nextToken());
                diff_y = Integer.parseInt(st.nextToken());
                radius = Integer.parseInt(st.nextToken());
                start_equation = (int)Math.pow(starting_point.getX_pos()-diff_x,2) + (int)Math.pow(starting_point.getY_pos()-diff_y,2);
                dest_equation = (int)Math.pow(destination.getX_pos()-diff_x,2) + (int)Math.pow(destination.getY_pos()-diff_y,2);
                if( start_equation < radius*radius && dest_equation > radius*radius)
                    count++;
                if( start_equation > radius*radius && dest_equation < radius*radius)
                    count++;
            }
            sb.append(count+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
