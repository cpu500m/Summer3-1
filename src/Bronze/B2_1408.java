package Bronze;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class B2_1408 {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String cur = br.readLine();
        String start = br.readLine();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        Date d_cur = format.parse(cur);
        Date d_start = format.parse(start);


        long diff = d_start.getTime() - d_cur.getTime();
        long t = diff / 1_000;

        if(t <0) t += 60 * 60 * 24;

        long hour = t/3600;
        long min = (t/60)  % 60;
        long sec = t % 60;

        if(hour < 10) sb.append("0");
        sb.append(hour + ":");
        if(min < 10) sb.append("0");
        sb.append(min+":");
        if(sec <10) sb.append("0");
        sb.append(sec);
        bw.write(sb.toString());
        bw.flush();
    }
}
