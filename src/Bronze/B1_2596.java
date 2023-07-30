package Bronze;

import java.io.*;

public class B1_2596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] ref_arr = {"000000", "001111" , "010011"
                            , "011100", "100110", "101001"
                            , "110101", "111010"};

        for (int i = 0; i < cnt; i++) {
            String sub_str = str.substring(i*6 , (i+1)*6);
            for (int j = 0; j < ref_arr.length; j++) {
                int diff_cnt = 0;
                for (int k = 0; k < ref_arr[j].length(); k++) {
                    if(ref_arr[j].charAt(k) != sub_str.charAt(k)) {
                        diff_cnt++;
                        if(diff_cnt >1 )
                            break;
                    }
                }
                if(diff_cnt < 2) {
                    sb.append((char)('A' + j));
                    break;
                }
            }
            if(sb.length() != i+1){
                sb.setLength(0);
                sb.append(String.valueOf(i + 1));
                break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
