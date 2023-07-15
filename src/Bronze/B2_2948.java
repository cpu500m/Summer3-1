package Bronze;

import java.io.*;
import java.util.Calendar;

public class B2_2948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final String[] WEEK = {"Sunday" , "Monday" , "Tuesday" , "Wednesday" , "Thursday", "Friday", "Saturday"};
        String[] day = br.readLine().split(" ");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2009, Integer.parseInt(day[1])-1, Integer.parseInt(day[0]));
        int d = calendar.get(Calendar.DAY_OF_WEEK);
        bw.write(WEEK[d - 1]);
        bw.flush();
    }
}
