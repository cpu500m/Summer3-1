package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_30502 {
    static class Plant{
        int p;
        int m;
        Plant(){
            this.p = -1;
            this.m = -1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Plant[] plants = new Plant[n];

        ConstructArr(n, plants);

        initArr(br, m, plants);

        int min = 0 , max = n;
        for (int i = 0; i < n; i++) {
            Plant cur = plants[i];
            if(cur.p == 1 && cur.m == 0) min++;
            if(cur.p == 0 || cur.m == 1) max--;
        }

        bw.write(min + " " + max);
        bw.flush();

    }

    private static void initArr(BufferedReader br, int m, Plant[] plants) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            char b = st.nextToken().charAt(0);
            int c = Integer.parseInt(st.nextToken());
            if(b == 'P') plants[num].p = c;
            else plants[num].m = c;
        }
    }

    private static void ConstructArr(int n, Plant[] plants) {
        for (int i = 0; i < n; i++) {
            plants[i] = new Plant();
        }
    }
}
