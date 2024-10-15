package Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author : paulkim
 * @description :
 * @packageName : Gold
 * @fileName : G4_16434
 * @date : 2024-10-15
 */
public class G4_16434 {

    private static final long MAX = (long)10e16;
    private static final int MONSTER = 1;
    private static final int HEAL = 1;

    private static long result = MAX;
    private static Room[] rooms;
    private static long playerAtk;


    public static class Room{
        int type;
        long atk;
        long hp;

        Room(int type, long atk, long hp){
            this.type = type;
            this.atk = atk;
            this.hp = hp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        playerAtk = Integer.parseInt(st.nextToken());

        rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long left = 1;
        long right = MAX;

        while (left < right){
            long mid = left + (right - left)/ 2;

            // 용을 쓰터트렸다면
            if(clearDungeon(mid)){
                if(result > mid){
                    result = mid;
                }
                right = mid;
            } else left = mid+1;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static boolean clearDungeon(long startHp){
        long curHp = startHp;
        long playerCurAtk = playerAtk;
        for(Room room : rooms){
            if(room.type == MONSTER) {
                long hitCount = (long)Math.ceil((double)room.hp / playerCurAtk) -1;
                long damage = hitCount * room.atk;
                curHp -= damage;

                // 몬스터에게 패배
                if(curHp <= 0){
                    return false;
                }
            } else{
                playerCurAtk += room.atk;
                curHp += room.hp;

                // 최대 체력으로 회복
                if(curHp >= startHp){
                    curHp = startHp;
                }
            }
        }
        return true;
    }
}
