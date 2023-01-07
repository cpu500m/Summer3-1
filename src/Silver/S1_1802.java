// 처음에 문제 읽고 약간 어지러웠는데
// 다시 정신차리고 생각해보니깐
// 그냥 절반기준으로 항상 0과 1이 대칭을 이루면 되는것이 아닌가 라는 생각이 듦. 그대로 해봄
// 근데이게 단순히 가운데에서 한칸씩 가며 했는데
// 제출해보니깐 틀려서 생각해보니
// 절반이 나뉘었을때 또 그를 기준으로 좌우대칭이 이루어져야함.
package Silver;

import java.io.*;

public class S1_1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop_count = Integer.parseInt(br.readLine());
        // index
        int i, j , mid;
        boolean flag;
        String str;
        for(i = 0 ; i < loop_count ; i++) {
            flag = true;
            str = br.readLine();
            // 위까진 오케이 입력처리니까
            if(!is_symmetry(str,0,str.length()-1))
                bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
    }
    static boolean is_symmetry(String str , int start, int end){
        if(start >= end)
            return false;
        // index
        int mid = (start+end)/2;
        int i , down , up;
        for (i = 1; i < (end-start)/2+1 ; i++) {
            down = mid - i;
            up = mid + i;
            if(str.charAt(down) == str.charAt(up))
                return true;
        }
        return is_symmetry(str, start ,(start+end)/2-1) || is_symmetry(str, (start+end)/2+1, end);
    }
}
