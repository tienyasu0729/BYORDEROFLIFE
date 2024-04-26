package JPD;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.next();

////        String list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to,na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo,ya,yu,yo,ra,ri,ru,re,ro,wa,o";
//        String translate;
        String list1;
////        list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to";
////        translate = "あ,い,う,え,お,か,き,く,け,こ,さ,し,す,せ,そ,た,ち,つ,て,と";
//
////        list1 = "na,ni,nu,ne,no";
////        translate = "な,に,ぬ,ね,の";
//
//        list1 = "ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to,na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo";
//        translate = "か,き,く,け,こ,さ,し,す,せ,そ,た,ち,つ,て,と,な,に,ぬ,ね,の,は,ひ,ふ,へ,ほ,ま,み,む,め,も";
//
////        list1 = "na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo,ya,yu,yo,ra,ri,ru,re,ro,wa,n";
////        translate = "な,に,ぬ,ね,の,は,ひ,ふ,へ,ほ,ま,み,む,め,も,や,ゆ,よ,ら,り,る,れ,ろ,わ,ん";

//        list1 = "かばん,ズボン,Tシャツ,とけい,～えん,いくら,じゃ,さかな,にく,ぎゅうにく,ぶたにく,やさい,いちご,りんご,りょうり,カレー,スープ,とんかつ,ハンバーグ,ごはん,ライス,ジュース,コーヒー,こうちゃ,（お）ちゃ,ビール";
//        list1 = "sa,shi,su,se,so";
//        list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to";

//        list1 = "ra,ri,ru,re,ro";
//        list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to,na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo,ra,ri,ru,re,ro";

//        int randomindex;
//        int[] tran = new int[4];
//        String[] a = list1.split(",");
////        String[] b = translate.split(",");
//        for (int i = 1; i <= 27; i++) {
//            System.out.print("\n" + i + ". ");
//            for (int j = 0; j < tran.length; j++) {
//                randomindex = (int) (Math.random() * (a.length));
//                tran[j] = randomindex;
//                System.out.print(a[randomindex]);
//            }
//            System.out.println();

//            System.out.println();
//            for (int j = 0; j < tran.length; j++) {
//                System.out.print(b[tran[j]]);
//            }

//        }

//        String day [] = new String[31];
//        String age [] = new String[100];
//        String number [] = new String[100];
//
//        int max = 31;
//        int min = 1;
//        for (int i = 0; i < 50; i++) {
//            number[i] = String.valueOf((int) (Math.random() * (max - min + 1)) + min);
//        }
//
//        for (int i = 1; i <= 31; i++) {
//            day[i-1] = "ngày " + i;
//        }
//
//        for (int i = 1; i <= 100; i++) {
//            age[i-1] = "tuổi " + i;
//        }
//
//        String array [] = Stream.concat(Stream.concat(Arrays.stream(day),Arrays.stream(age)), Arrays.stream(number)).toArray(String[]::new);
//        for (int i = 0; i < 20; i++) {
//            System.out.println(array[(int) (Math.random() * 181) + 1]);
//            System.out.println();
//        }
//
//        int max = 1;
//        int min = 31;
//        for (int i = 0; i < 20; i++) {
//            System.out.println((int) (Math.random() * (max - min + 1)) + min);
//            System.out.println();
//        }

        list1 = "Tôi, tên, Đất Nước, Nhật Bản, Hàn Quốc, Trung Quốc, Mỹ, Ý, Úc, Nga, Thái, Trường cấp 3, Trường đại học, Trường Tiếng Nhật, Công việc, Học sinh, Thầy cô (xưng cô), Giáo viên, Nhân viên văn phòng, (tên cty) Nhân viên, Người (nước nào), Tiếng (nước nào), Xin chào (lần đầu gặp), Rất mong bạn giúp đỡ, Chính tôi mới là người (cần …), (ngập ngừng trc khi hỏi điều gì), Xin lỗi, Thế à (tiếp nhận thông tin), Ở đâu, Ngày sinh/sinh nhật, Brazil, Tháng (479) (trên lịch), Ngày (trên lịch), Tuổi (180), Lúc nào khi nào, Sở thích, Thể thao, Bóng đá, Bơi lội, Âm nhạc, Đọc sách, Du lịch, Món ăn, Cái gì, A! / Á!, Mỗi sáng";

        int randomindex;
        int[] tran = new int[1];
        String[] a = list1.split(",");
//        String[] b = translate.split(",");
        for (int i = 1; i <= 27; i++) {
            System.out.print("\n" + i + ". ");
            for (int j = 0; j < tran.length; j++) {
                randomindex = (int) (Math.random() * (a.length));
                tran[j] = randomindex;
                System.out.print(a[randomindex]);
            }
            System.out.println();
        }
    }
}
