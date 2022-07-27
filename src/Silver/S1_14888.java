package Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S1_14888 {
    private static int[] arr;
    private static int N;
    private static int min =Integer.MAX_VALUE, max= Integer.MIN_VALUE;
    private static int[] operator_count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        operator_count = new int[4];
        for(int i =0; i <N;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < 4; i++)
            operator_count[i] = Integer.parseInt(st.nextToken());
        insertOperator( arr[0],1);
        bw.write(max+"\n"+min);
        bw.flush();
    }
    public static void insertOperator(int value, int index) {
        if (index == N) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
            return;
        }

        if (promise(0)) {
            operator_count[0]--;
            insertOperator(value+arr[index],index + 1);
            operator_count[0]++;
        }


        if(promise(1)) {
            operator_count[1]--;
            insertOperator(value-arr[index],index + 1);
            operator_count[1]++;
        }



        if(promise(2)) {
            operator_count[2]--;
            insertOperator(value*arr[index],index + 1);
            operator_count[2]++;
        }

        if(promise(3)) {
            operator_count[3]--;
            insertOperator(value/arr[index],index + 1);
            operator_count[3]++;
        }
    }
    public static boolean promise(int i){
        if(operator_count[i]  < 1)
            return false;
        return true;
    }
}
