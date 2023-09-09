package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_1350 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] size = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        int cluster_size = Integer.parseInt(br.readLine());
        long result = 0;
        for (int i = 0; i < n; i++) {
            int val = findVal(size[i], cluster_size);
            result += val*cluster_size;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
    private static int findVal(int file_size, int cluster_size) {
        if (file_size % cluster_size != 0) {
            return (file_size / cluster_size)+1;
        }
        return file_size / cluster_size;
    }
}
