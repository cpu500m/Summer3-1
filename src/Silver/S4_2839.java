/* 2022 - 06 - 20 월 첫 문제. */

package Silver;

import java.util.Scanner;

public class S4_2839 {
    public static void main(String[] args) {
        int count = 0;
        int total;
        Scanner scanner = new Scanner(System.in);
        total = scanner.nextInt();
        while (total >= 0) {
            if ((total - 5) >= 0&& total % 5 == 0){
                count++;
                total -= 5;
                if (total == 0) {
                    System.out.print(count);
                    return ;
                }
            }
            else if ((total - 3) >= 0 && total % 3 == 0) {
                count++;
                total -= 3;
                if (total == 0) {
                    System.out.print(count);
                    return ;
                }
            }
            else if ((total - 5) >= 0){
                count++;
                total -= 5;
                if (total == 0) {
                    System.out.print(count);
                    return ;
                }
            }
            else if ((total - 3) >= 0) {
                count++;
                total -= 3;
                if (total == 0) {
                    System.out.print(count);
                    return ;
                }
            }
            else break;
        }
        System.out.print("-1");
    }
}