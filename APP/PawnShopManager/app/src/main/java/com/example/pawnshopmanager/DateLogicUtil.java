package com.example.pawnshopmanager; // Đảm bảo tên gói này khớp với dự án của bạn

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class DateLogicUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public enum ItemStatus {
        ACTIVE,
        NEARING, // Sắp hết hạn
        OVERDUE // Quá hạn
    }

    /**
     * Lấy ngày hôm nay dưới dạng chuỗi "yyyy-MM-dd"
     */
    public static String getTodayString() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        return sdf.format(new Date());
    }

    /**
     * Tính toán ngày hết hạn dựa trên ngày cầm và loại vật phẩm
     */
    public static Date getDueDate(String pawnDateStr, String itemType) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        try {
            Date pawnDate = sdf.parse(pawnDateStr);
            Calendar c = Calendar.getInstance();
            c.setTime(pawnDate);

            switch (itemType) {
                case "phone":
                    c.add(Calendar.DAY_OF_MONTH, 10);
                    break;
                case "laptop":
                    c.add(Calendar.DAY_OF_MONTH, 20);
                    break;
                case "vehicle":
                    c.add(Calendar.MONTH, 1);
                    break;
            }
            return c.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date(); // Trả về ngày hôm nay nếu lỗi
        }
    }

    // Hàm chuẩn hóa ngày (xóa giờ, phút, giây) để so sánh
    private static Date zeroTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * Lấy trạng thái của vật phẩm (Quá hạn, Sắp hạn, Còn hạn)
     */
    public static ItemStatus getItemStatus(String pawnDateStr, String itemType) {
        Date dueDate = zeroTime(getDueDate(pawnDateStr, itemType));
        Date today = zeroTime(new Date()); // Ngày hôm nay

        // Tính số ngày chênh lệch
        long diffInMillis = dueDate.getTime() - today.getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        if (diffInDays < 0) {
            return ItemStatus.OVERDUE;
        } else if (diffInDays <= 2) {
            return ItemStatus.NEARING;
        } else {
            return ItemStatus.ACTIVE;
        }
    }

    /**
     * Lấy chuỗi mô tả trạng thái (ví dụ: "Quá hạn 3 ngày")
     */
    public static String getStatusString(String pawnDateStr, String itemType) {
        Date dueDate = zeroTime(getDueDate(pawnDateStr, itemType));
        Date today = zeroTime(new Date());

        long diffInMillis = dueDate.getTime() - today.getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        if (diffInDays < 0) {
            return "Quá hạn " + Math.abs(diffInDays) + " ngày";
        } else if (diffInDays == 0) {
            return "Hôm nay";
        } else if (diffInDays <= 2) {
            return "Còn " + diffInDays + " ngày";
        } else {
            return "Còn " + diffInDays + " ngày";
        }
    }

    /**
     * HÀM MỚI: Tính tiền lãi cho một chu kỳ.
     * Yêu cầu: 3.000đ / 1 triệu
     * Giả định: Đây là lãi cho chu kỳ 10 NGÀY (gói điện thoại).
     * Lãi suất sẽ nhân lên 2 (cho 20 ngày) và 3 (cho 1 tháng).
     */
    public static double calculateInterest(Item item) {
        if (item == null) return 0;

        double giaTienCam = item.getGiaTienCam();
        String type = item.getType();

        // 1. Tính lãi suất cơ bản (cho 10 ngày)
        // Cứ 1.000.000 thì lãi 3.000
        double baseInterestRate = 3000.0;
        double baseAmount = 1000000.0;

        // Tính số "suất" 1 triệu (ví dụ: 15tr = 15 suất)
        double interestUnits = giaTienCam / baseAmount;

        double baseInterest = interestUnits * baseInterestRate;

        // 2. Nhân lên theo loại vật phẩm
        switch (type) {
            case "phone": // 10 ngày
                return baseInterest;
            case "laptop": // 20 ngày (gấp 2 lần chu kỳ 10 ngày)
                return baseInterest * 2;
            case "vehicle": // 1 tháng (tạm tính 30 ngày, gấp 3)
                return baseInterest * 3;
            default:
                return 0;
        }
    }
}