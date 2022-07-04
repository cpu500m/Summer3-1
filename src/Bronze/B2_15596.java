package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_15596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int len = Integer.parseInt(br.readLine());
        int[] a = new int[len];
        st= new StringTokenizer(br.readLine());
        for(int i =0; i<len; i++)
            a[i]=Integer.parseInt(st.nextToken());
        sum(a);
    }
    static long sum(int[] a){
        long result=0;
        for(int i =0 ; i <a.length; i++){
            result += a[i];
        }
        return result;
    }
}
