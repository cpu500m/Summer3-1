/* 2022-07-11 */
// 같은모양이 계속9번 반복된다고 생각하면서 풀긴 했는데
// 시간측면에서 효율은 나쁘지 않게 나타나지만
// 뭔가 코드가 좀 알아보기 힘들긴 함.
// 나중에 다시 해볼 필요가 있을듯.

package Gold;

import java.io.*;

public class G5_2447 {
    private static char[][] star;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        star = new char[n+1][n+1];
        storeStar(n);
        for(int i = 1 ; i < n+1; i++) {
            for (int j = 1; j < n + 1; j++)
                bw.write(star[i][j]);
            bw.write("\n");
        }
        bw.flush();
    }
    public static void storeStar(int n){
        if(n == 1) {
            star[1][1] = '*';
            return ;
        }
        storeStar(n/3);
        // 같은 모양을 8번 + 공백모양 1번 반복해서 그린다고 생각 .
            for(int y = 1 ; y < (n/3)+1 ; y++){
                for(int x = 1 ; x < (n/3)+1 ; x++){
                    for(int add_y = 0 ; add_y < n ; add_y+=n/3)
                        for(int add_x = 0 ; add_x < n;  add_x+=n/3){
                            if( add_y == n/3 && add_x == n/3) {
                                star[y + add_y][x + add_x] = ' ';
                                continue;
                            }
                            star[y+add_y][x+add_x] = star[y][x];
                        }
                }
            }
    }
}
