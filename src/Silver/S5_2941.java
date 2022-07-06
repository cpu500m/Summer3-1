package Silver;

import java.io.*;

public class S5_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int count = 0;
        for(int i =0 ; i < str.length(); ) {
            if (i == str.length()-1) {
                count++;
                break;
            }
            if (i < str.length() - 2) {
                 if (str.charAt(i) == 'd' && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                    count++;
                    i += 3;
                }
                 else if (str.charAt(i) == 'c' && str.charAt(i + 1) == '=') {
                     count++;
                     i += 2;
                 } else if (str.charAt(i) == 'c' && str.charAt(i + 1) == '-') {
                     count++;
                     i += 2;
                 } else if (str.charAt(i) == 'd' && str.charAt(i + 1) == '-') {
                     count++;
                     i += 2;
                 }
                 else if (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') {
                     count++;
                     i += 2;
                 } else if (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') {
                     count++;
                     i += 2;
                 } else if (str.charAt(i) == 's' && str.charAt(i + 1) == '=') {
                     count++;
                     i += 2;
                 } else if (str.charAt(i) == 'z' && str.charAt(i + 1) == '=') {
                     count++;
                     i += 2;
                 }
                 else{
                     count++;
                     i++;
                 }
            }
            else {
                if (str.charAt(i) == 'c' && str.charAt(i + 1) == '=') {
                    count++;
                    i += 2;
                } else if (str.charAt(i) == 'c' && str.charAt(i + 1) == '-') {
                    count++;
                    i += 2;
                } else if (str.charAt(i) == 'd' && str.charAt(i + 1) == '-') {
                    count++;
                    i += 2;
                }
                else if (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') {
                    count++;
                    i += 2;
                } else if (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') {
                    count++;
                    i += 2;
                } else if (str.charAt(i) == 's' && str.charAt(i + 1) == '=') {
                    count++;
                    i += 2;
                } else if (str.charAt(i) == 'z' && str.charAt(i + 1) == '=') {
                    count++;
                    i += 2;
                }
                else{
                    count++;
                    i++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
