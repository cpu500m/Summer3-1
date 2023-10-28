package Bronze;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class B2_30403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] compareStr = {"roygbiv", "ROYGBIV"};
        boolean[] check = new boolean[2];
        Map<Character, Boolean> map = new HashMap<>();

        initMap(str, map);

        logic(compareStr, check, map);

        printResult(bw, check);

    }

    private static void printResult(BufferedWriter bw, boolean[] check) throws IOException {
        if(check[0]){
            if(check[1]) {
                bw.write("YeS");
            } else bw.write( "yes");
        } else{
            if(check[1])
                bw.write("YES");
            else bw.write("NO!");
        }

        bw.flush();
    }

    private static void logic(String[] compareStr, boolean[] check, Map<Character, Boolean> map) {
        for (int i = 0; i < compareStr.length; i++) {
            boolean curCheck = true;
            for (int j = 0; j < compareStr[0].length(); j++) {
                if(!map.containsKey(compareStr[i].charAt(j))) {
                    curCheck = false;
                    break;
                }
            }
            check[i] = curCheck;
        }
    }

    private static void initMap(String str, Map<Character, Boolean> map) {
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), true);
        }
    }
}
