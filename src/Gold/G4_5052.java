package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_5052
 * @date : 25. 4. 27.
 */
public class G4_5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            int n= Integer.parseInt(br.readLine());
            Set<String> set = new HashSet<>();
            List<String> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                String curString = br.readLine();
                set.add(curString);
                list.add(curString);
            }
            list.sort(String::compareTo);

            boolean isConsistent = true;
            for (String str : list) {
                for (int j = 0; j < str.length() -1; j++) {
                    String subString = str.substring(0, j+1);
                    if(set.contains(subString)) {
                        isConsistent = false;
                    }
                }
                if(!isConsistent){
                    break;
                }
            }
            sb.append(isConsistent ? "YES" : "NO");
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
