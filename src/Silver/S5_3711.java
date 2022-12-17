package Silver;

import java.io.*;

public class S5_3711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt;
        int i ,j , div_value;
        int[] value, remainder;
        boolean flag;
        for(i = 0 ; i < n ; i++){
            div_value = 1;
            cnt = Integer.parseInt(br.readLine());
            value = new int[cnt];
            for(j = 0 ; j < cnt ; j++){
                value[j] = Integer.parseInt(br.readLine());
            }
            while(true){
                flag = false;
                remainder = new int[cnt];
                remainder[0] = value[0]%div_value;
                for(j = 1 ; j < cnt ; j++){
                    remainder[j] = value[j]%div_value;
                    for(int k = 0 ; k < j ; k++){
                        if(remainder[k] == remainder[j]){
                            flag= true;
                            break;
                        }
                    }
                    if(flag)
                        break;
                }
                if(!flag){
                    sb.append(div_value+"\n");
                    break;
                }
                div_value++;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
