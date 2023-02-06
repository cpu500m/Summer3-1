package Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S4_1015 {
    static class Element{
        int idx, value, convert_val;
        Element(int idx ,int value){
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Element[] arr = new Element[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;  i < N ; i++)
            arr[i] = new Element(i , Integer.parseInt(st.nextToken()));

        Arrays.sort(arr, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if(o1.value == o2.value)
                    return o1.idx - o2.idx;
                return o1.value- o2.value;
            }
        });
        for(int i = 0 ; i < N ; i++)
            arr[i].convert_val = i;

        Arrays.sort(arr, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.idx - o2.idx;
            }
        });

        for(int i =  0 ; i <N ; i++)
            sb.append(arr[i].convert_val+" ");
        bw.write(sb.toString());
        bw.flush();
    }
}
