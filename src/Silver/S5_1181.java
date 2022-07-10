package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class S5_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        String[] arr = new String[size];
        for(int i = 0 ; i <size; i ++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if( s1.length() == s2.length())
                    return s1.compareTo(s2);
                else
                    return s1.length()-s2.length();
            }
        });
        sb.append(arr[0]+"\n");
        for(int i = 1; i < size; i ++) {
            if(arr[i].compareTo(arr[i-1]) != 0)
                sb.append(arr[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
