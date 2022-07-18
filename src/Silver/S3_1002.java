package Silver;

import java.io.*;
import java.util.StringTokenizer;

class Turret{
    private int x;
    private int y;
    private int distance;
    Turret(int x, int y ,int distance){
        this.x = x;
        this.y= y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }
}
public class S3_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int loop_count = Integer.parseInt(br.readLine());
        int radius_sum;
        int radius_minus;
        int center_distance;
        Turret seokWon , seungHwan;
        for(int i = 0 ; i < loop_count ; i++){
            st = new StringTokenizer(br.readLine());
            seokWon = new Turret(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            seungHwan = new Turret(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            center_distance = (int)(Math.pow(seokWon.getX()-seungHwan.getX(),2) +Math.pow(seokWon.getY()-seungHwan.getY(),2));
            radius_sum = seokWon.getDistance()+seungHwan.getDistance();
            radius_minus = Math.abs(seokWon.getDistance()-seungHwan.getDistance());

            if( center_distance > (int)Math.pow(radius_sum,2))
                sb.append("0\n");
            else if(center_distance == (int)Math.pow(radius_sum,2))
                sb.append("1\n");
            else if((int)Math.pow(radius_minus,2) < center_distance &&center_distance < (int)Math.pow(radius_sum,2))
                sb.append("2\n");
            else if((int)Math.pow(radius_minus,2) == center_distance && radius_minus !=0 )
                sb.append("1\n");
            else if((int)Math.pow(radius_minus,2) > center_distance)
                sb.append("0\n");
            else if(seokWon.getDistance() == 0 && seungHwan.getDistance() == 0 && center_distance==0)
                sb.append("1\n");
            else if(center_distance == 0 && seokWon.getDistance() == seungHwan.getDistance())
                sb.append("-1\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
