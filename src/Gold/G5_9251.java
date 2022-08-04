package Gold;

import java.io.*;

public class G5_9251 {
    private static String str1, str2;
    private static int[][] LCS_length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str1 = br.readLine();
        str2 = br.readLine();
        LCS_length = new int[str1.length() + 1][str2.length() + 1];
        bw.write(String.valueOf(get_LCSLength(str1.length(), str2.length())));
        bw.flush();
    }

    private static int get_LCSLength(int row, int col) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    LCS_length[i][j] = LCS_length[i - 1][j - 1] + 1;
                else
                    LCS_length[i][j] = Math.max(LCS_length[i - 1][j], LCS_length[i][j - 1]);
            }
        }
        return LCS_length[row][col];
    }
}
