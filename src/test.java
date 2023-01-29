import java.io.*;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] temp = new char[5];
        temp[0] = 'h'; temp[1] = 'e'; temp[2] ='\0';
        String s = temp.toString();
        bw.write(s+"\n");
        StringTokenizer st  = new StringTokenizer(s , "/\0");
        bw.write(String.valueOf(st.countTokens()));
        bw.flush();
    }
}
