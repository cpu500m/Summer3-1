package Bronze;

import java.io.*;

public class B1_1157 {
    static final int SIZE= 26;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[] count = new int[SIZE];
        int max = 0;
        char most_frequent='?';
        for(int i = 0 ; i < str.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == str.charAt(i) || c-32 == str.charAt(i))
                    count[c - 'a']++;
            }
        }
        for(int i = 0 ; i < SIZE; i++){
            if(max < count[i]){
                max = count[i];
                most_frequent = (char)(i+'A');
            }
            else if(max!=0 && max == count[i]){
                most_frequent = '?';
            }
        }
        bw.write(most_frequent);
        bw.flush();
    }
}
