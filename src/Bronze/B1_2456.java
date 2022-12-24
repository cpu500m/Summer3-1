package Bronze;

import java.io.*;
import java.util.StringTokenizer;

public class B1_2456 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int i , j;
        int max = -1, m_num = 0;
        int arr[] = new int[3];
        int cnt[][] = new int[3][3];
        int cur;
        StringTokenizer st;
        for(i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(j = 0 ; j < 3 ; j++) {
                cur =Integer.parseInt(st.nextToken());
                arr[j] += cur;
                cnt[j][cur-1]++;
            }
        }
        for(i = 0 ; i <3 ; i++){
            if(max < arr[i]) {
                max = arr[i];
                m_num = i+1;
            }
            else if(max == arr[i]){
                if(cnt[m_num-1][2] < cnt[i][2])
                    m_num = i+1;
            }
        }
        for(i = 0 ; i <3 ; i++){
            if(i == m_num-1)
                continue;
            if(arr[i] == arr[m_num-1]){
                if(cnt[i][2] == cnt[m_num-1][2])
                    if(cnt[i][1] == cnt[m_num-1][1]){
                        m_num = 0;
                        break;
                    }
            }
        }
        bw.write(m_num+" "+max);
        bw.flush();
    }
}
