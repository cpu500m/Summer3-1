package Bronze;

import java.io.*;

public class B3_4766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        double pre_input = Double.parseDouble(br.readLine());
        double cur_input;
        while(true){
            str = br.readLine();
            if(str.equals("999"))
                break;
            cur_input = Double.parseDouble(str);
            sb.append(String.format("%.2f",cur_input-pre_input)+"\n");
            pre_input = cur_input;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
