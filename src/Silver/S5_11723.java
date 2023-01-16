package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String command;
        boolean[] check = new boolean[21];
        // index
        int i ,j, cur;

        /*  입력  처리  */
        int M = Integer.parseInt(br.readLine());
        for(i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(command.equals("add")){
                cur = Integer.parseInt(st.nextToken());
                check[cur] = true;
            }
            else if(command.equals("remove")){
                cur = Integer.parseInt(st.nextToken());
                check[cur] = false;
            }
            else if(command.equals("check")){
                cur = Integer.parseInt(st.nextToken());
                if(check[cur])
                    bw.write("1\n");
                else bw.write("0\n");
            }
            else if(command.equals("toggle")){
                cur = Integer.parseInt(st.nextToken());
                check[cur] = !check[cur];
            }
            else if(command.equals("all")){
                Arrays.fill(check ,true);
            }
            else if(command.equals("empty"))
                Arrays.fill(check ,false);
        }
        bw.flush();
    }
}
