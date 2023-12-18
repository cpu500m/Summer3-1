package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S5_11728 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size1 = Integer.parseInt(st.nextToken());
        int size2 = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        insert2Arr(br, size1, list);
        insert2Arr(br, size2, list);

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)+" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void insert2Arr(BufferedReader br, int size, List<Integer> list) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }
}
