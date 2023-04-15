package Bronze;

import java.io.*;

public class B3_4493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1;  tc <= TC ; ++tc){
            int win_cnt = 0 , lose_cnt = 0;
            int iteration = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < iteration ; i ++){
                String[] hands = br.readLine().split(" ");
                if(hands[0].equals("R")){
                    if(hands[1].equals("S"))
                        win_cnt++;
                    else if(hands[1].equals("P"))
                        lose_cnt++;
                }
                else if(hands[0].equals("S")){
                    if(hands[1].equals("P"))
                        win_cnt++;
                    else if(hands[1].equals("R"))
                        lose_cnt++;
                }
                else if(hands[0].equals("P")){
                    if(hands[1].equals("R"))
                        win_cnt++;
                    else if(hands[1].equals("S"))
                        lose_cnt++;
                }
            }

            if(win_cnt > lose_cnt)
                sb.append("Player 1\n");
            else if(win_cnt < lose_cnt)
                sb.append("Player 2\n");
            else sb.append("TIE\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
