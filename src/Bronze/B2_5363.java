package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B2_5363 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String[] str = new String[2];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            str[0]= st.nextToken();
            str[1] = st.nextToken();
            while(st.hasMoreElements()){
                sb.append(st.nextToken()+" ");
            }
            sb.append(str[0]+" ");
            sb.append(str[1]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
