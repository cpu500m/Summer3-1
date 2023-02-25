package Bronze;

        import java.io.*;

public class B5_20492 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long s = (N*80)/100 + ((long)N*20*78)/10000;
        bw.write((N*78)/100+" ");
        bw.write(String.valueOf(s));
        bw.flush();
    }
}
