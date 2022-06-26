/* 2022-06-26 */
package Bronze;

import java.util.Scanner;

public class B3_2884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        if(minute - 45 < 0 ){
            if(hour-1 < 0){
                System.out.print("23 "+(60-45+minute));
            }
            else{
                System.out.print((hour-1) +" "+(60-45+minute));
            }
        }
        else{
            System.out.print(hour+" "+(minute-45));
        }
    }
}
