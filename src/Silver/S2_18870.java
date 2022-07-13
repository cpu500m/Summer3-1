// 그냥 가장 간단하게 범위 내의 숫자만큼의 boolean 배열을 만들어서 할까 했지만
// 2GB정도의 공간이 필요하므로 다른 방법 모색.
// N크기의 int 배열을 만들고
// 입력갑들을 받고 오름차순으로 정렬.
// 그리고 차례대로 압축 시키면 될듯
package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Position {
    private int pos;
    private int order;
    private int compress_pos;
    Position(int pos, int order){
        this.pos = pos;
        this.order = order;
    }

    public int getPos() {
        return pos;
    }

    public int getOrder() {
        return order;
    }

    public int getCompress_pos() {
        return compress_pos;
    }

    public void setCompress_pos(int compress_pos) {
        this.compress_pos = compress_pos;
    }
}
public class S2_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int count = 0 ;
        Position[] positions = new Position[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            positions[i] = new Position(Integer.parseInt(st.nextToken()), i);
        }
        Comparator<Position> firstSort = new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.getPos()-o2.getPos();
            }
        };
        Arrays.sort(positions, firstSort);
        positions[0].setCompress_pos(count);
        for(int i = 1 ; i < N  ; i++){
            if(positions[i].getPos() == positions[i-1].getPos())
                positions[i].setCompress_pos(count);
            else
                positions[i].setCompress_pos(++count);
        }
        Comparator<Position> secondSort = new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return o1.getOrder() - o2.getOrder();
            }
        };
        Arrays.sort(positions, secondSort);
        for(int i = 0 ; i < N ; i++)
            sb.append(positions[i].getCompress_pos()+" ");
        bw.write(sb.toString());
        bw.flush();

    }
}
