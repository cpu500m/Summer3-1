package Silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S2_1058 {
    static class Person {
        List<Integer> friend_list = new ArrayList<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 걍 N 4승 떄려도 널널하니깐 빨리 짜자
        Person[] people = new Person[N+1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            people[i] = new Person();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'Y')
                    people[i].friend_list.add(j + 1);
            }
        }

        // 찾기
        int max_2friend = -1;
        for (int i = 1; i <= N; i++) {
            List<Integer> cur_list = people[i].friend_list;
            int cnt = 0;
            // 이미 2-친구 임이 확인됐는가
            boolean[] checked = new boolean[N + 1];
            for (Integer friend_idx : cur_list) {
                // 2-친구 맺음
                if(!checked[friend_idx]){
                    checked[friend_idx] = true;
                    cnt++;
                }
                // 해당 친구의 친구를 찾는다
                List<Integer> near_list = people[friend_idx].friend_list;
                for (Integer near_idx : near_list) {
                    if(!checked[near_idx] && near_idx != i){
                        checked[near_idx] = true;
                        cnt++;
                    }
                }
            }
            if (cnt > max_2friend)
                max_2friend = cnt;
        }
        bw.write(String.valueOf(max_2friend));
        bw.flush();
    }
}
