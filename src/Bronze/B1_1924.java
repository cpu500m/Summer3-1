package Bronze;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class B1_1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LocalDate date = LocalDate.of(2007, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        DayOfWeek day = date.getDayOfWeek();
        bw.write(day.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase());
        bw.flush();
    }
}
