package Bronze;

import java.io.*;

public class B3_30889 {

    private final static int ROW = 10;
    private final static int COL = 20;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[][] seat = new boolean[ROW][COL];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int num = Integer.parseInt(s.substring(1));
            seat[s.charAt(0) - 'A'][num - 1] = true;
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(seat[i][j]) sb.append('o');
                else sb.append('.');
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
