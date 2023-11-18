package Bronze;

import java.io.*;

public class B5_30676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int lambda = Integer.parseInt(br.readLine());
        if(lambda >= 620){
            bw.write("Red");
        } else if(lambda >= 590)
            bw.write("Orange");
        else if (lambda >= 570) {
            bw.write("Yellow");
        } else if (lambda >= 495) {
            bw.write("Green");
        } else if (lambda >= 450) {
            bw.write("Blue");
        } else if (lambda >= 425) {
            bw.write("Indigo");
        } else bw.write("Violet");
        bw.flush();
    }
}
