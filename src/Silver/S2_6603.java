package Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Silver
 * @fileName : S2_6603
 * @date : 2024-11-15
 */
public class S2_6603 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        while (!str.equals("0")){
            StringTokenizer st = new StringTokenizer(str," ");
            int size = Integer.parseInt(st.nextToken());
            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0,new ArrayList<Integer>(),arr,bw);
            bw.write("\n");
            str = br.readLine();
        }
        bw.flush();
    }

    private static void backTracking(int index, List<Integer> curList, int[] arr, BufferedWriter bw) throws IOException {
        if(curList.size() == 6){
            StringBuilder sb = new StringBuilder();
            for(Integer i : curList){
                sb.append(i + " ");
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;
        }

        for(int i = index ; i < arr.length ; i++){
            curList.add(arr[i]);
            backTracking(i + 1, curList, arr, bw);
            curList.remove(curList.size() - 1);
        }
    }
}
