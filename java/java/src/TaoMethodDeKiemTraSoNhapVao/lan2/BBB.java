package TaoMethodDeKiemTraSoNhapVao.lan2;

import java.util.Scanner;

public class BBB {
    public static Scanner scanner = new Scanner(System.in);
    public static int thu(int choose){
        do {
            System.out.println("nhâp : ");
            choose = Integer.parseInt(scanner.nextLine());
        }while (choose < 5);
        return choose;
    }
}
