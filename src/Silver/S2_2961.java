package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S2_2961 {
    private static int opt = Integer.MAX_VALUE;
    private static boolean[] check;
    static class Info{
        int s;
        int b;

        public Info(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        check = new boolean[n];
        Info[] info = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        logic(0,0,0,info);
        bw.write(String.valueOf(opt));
        bw.flush();
    }

    private static void logic(int cur,int s,int b,Info[] info) {
        if(s!= 0){
            if(Math.abs(s-b) < opt){
                opt = Math.abs(s - b);
            }
        }
        for (int i = cur; i < info.length; i++) {
            check[i] = true;
            int curS = (s == 0? info[i].s : s*info[i].s);
            logic(i+1, curS,b+info[i].b, info);
            check[i] = false;
        }
    }
}
