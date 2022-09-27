package Bronze;

import java.io.*;
import java.util.*;

public class B1_2204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<String> arr;
        do{
            arr = new ArrayList<>();
            for(int i = 0 ; i < n; i++){
                arr.add(br.readLine());
            }
            Collections.sort(arr, new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o1.toLowerCase().compareTo(o2.toLowerCase());
                        }
                    });
                    sb.append(arr.get(0) + "\n");
            n = Integer.parseInt(br.readLine());
        }while(n !=0);
        bw.write(sb.toString());
        bw.flush();
    }
}
