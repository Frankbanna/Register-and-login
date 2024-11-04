import java.util.Scanner;

public class Registerandlogin {

    public static void main(String[] args) {

        String[][] userDatabase = new String[10][2];
        Scanner input = new Scanner(System.in);
        int userCount = 0;
        String TF = "";
        String username = "";
        String password = "";

        System.out.print("\nต้องการทำการหรือไม่? Y/N: ");
        TF = input.nextLine().toUpperCase();
        if (TF.equals("Y") || TF.equals("N")) {

            while (TF.equals("Y")) {
                System.out.println("\nเลือกทำการ");
                System.out.println("1: เข้าสู่ระบบ");
                System.out.println("2: ลงทะเบียน");
                System.out.print(" \nคำตอบคุณคือ(ตอบเป็นตัวเลข) : ");
                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1 || choice == 2) {

                    switch (choice) {

                        case 1:
                            System.out.print("\nชื่อผู้ใช้: ");
                            username = input.nextLine();
                            System.out.print("รหัสผ่าน: ");
                            password = input.nextLine();

                            for (int i = 0; i < userCount; i++) {
                                if (userDatabase[i][0].equals(username) && userDatabase[i][1].equals(password)) {
                                    System.out.println("\nเข้าสู่ระบบสำเร็จ!\n");
                                    System.out.println("welcome\n");
                                    return;
                                }

                            }
                            System.out.println("\n* เข้าสู่ระบบไม่สำเร็จ เนื่องจากไม่พบบัญชีผู้ใช้ กรุณาลองอีกครั้ง *");
                            break;

                        case 2:
                            System.out.print("\nกรุณาใส่ชื่อผู้ใช้ที่ต้องการลงทะเบียน: ");
                            username = input.nextLine();
                            for (int i = 0; i < userCount; i++) {
                                if (userDatabase[i][0].equals(username)) {
                                    System.out.println("\n* มีผู้ใช้ชื่อนี้แล้ว กรุณาใช้ชื่ออื่น *");
                                    do {
                                        System.out.print("\nกรุณาใส่ชื่อผู้ใช้ที่ต้องการลงทะเบียน: ");
                                        username = input.nextLine();

                                    } while (userDatabase[i][0].equals(username));
                                }

                            }

                            System.out.print("รหัสผ่าน: ");
                            password = input.nextLine();

                            userDatabase[userCount][0] = username;
                            userDatabase[userCount][1] = password;
                            userCount++;
                            System.out.println("\nลงทะเบียนสำเร็จ!");
                            break;

                        default:
                            System.out.println("\nออกจากโปรแกรม\n");
                            return;
                    }
                } else {
                    System.err.println("*** กรุณาเลือก 1 หรือ 2 ***");
                }
            }
            if (TF.equals("N")) {
                System.out.println("\nออกจากโปรแกรม\n");
                return;
            }
        } else {
            System.err.println("*** ออกจากระบบเพราะตอบไม่ตรงคำถาม ***");
        }
    }
}