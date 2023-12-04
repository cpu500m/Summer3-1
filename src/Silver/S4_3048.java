package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S4_3048 {
    final static int LEFT = 0;
    final static int RIGHT = 1;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int size = n1 + n2;
        int[] dir = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            dir[i] = RIGHT;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(br.readLine());
        sb.reverse();
        char[] arr = sb.append(br.readLine()).toString().toCharArray();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (dir[j] != dir[j + 1]) {
                    if(dir[j] == LEFT || dir[j+1] == RIGHT) continue;
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    int t = dir[j];
                    dir[j] = dir[j + 1];
                    dir[j + 1] = t;
                    j++;
                }
            }
        }
        bw.write(String.valueOf(arr));
        bw.flush();
    }
}
