package Silver;

import java.io.*;
import java.util.StringTokenizer;

class Info{
    private int direction;
    private int length;
    Info(int direction , int length){
        this.direction = direction;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getDirection() {
        return direction;
    }
}
public class S3_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        Info[] info = new Info[12];
        int[] direction = new int[5];
        int area = 0;
        for(int i = 0 ; i < 6; i++) {
            if((st = new StringTokenizer(br.readLine())) == null)
                break;
            info[i] = new Info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i = 0 ; i < 6 ; i++) {
            direction[info[i].getDirection()]++;
        }
        for(int i = 6; i <12 ; i++){
            info[i] = new Info(info[i-6].getDirection(), info[i-6].getLength());
        }
        for(int i = 0 ; i < 6 ; i++){
            if(direction[info[i].getDirection()] == 1 && direction[info[i+1].getDirection()] ==1){
                area = info[i].getLength()*info[i+1].getLength() - info[i+3].getLength()*info[i+4].getLength();
                break;
            }
            else if(direction[info[i].getDirection()] == 1 && direction[info[i+1].getDirection()] !=1){
                area = info[i].getLength()*info[i+5].getLength() - info[i+2].getLength()*info[i+3].getLength();
                break;
            }
        }
        bw.write(String.valueOf(area * count));
        bw.flush();
    }
}
