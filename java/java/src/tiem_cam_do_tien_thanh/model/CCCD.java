package tiem_cam_do_tien_thanh.model;

public class CCCD extends Human{
    private String dayIn;
    private String note;

    public CCCD(String cccd, String name, String phoneNumber, String dayIn, String note) {
        super(cccd, name, phoneNumber);
        this.dayIn = dayIn;
        this.note = note;
    }

//    public CCCD(String cccd, String name, String phoneNumber, String dayIn) {
//        super(cccd, name, phoneNumber);
//        this.dayIn = dayIn;
//    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDayIn() {
        return dayIn;
    }

    public void setDayIn(String dayIn) {
        this.dayIn = dayIn;
    }

    @Override
    public String toString() {
        return String.format("%s , %s , %s , %s , %s",super.getCccd(),super.getName(),super.getPhoneNumber(),getDayIn(),getNote());
    }

//    public String Note() {
//        return String.format("%s , %s , %s , %s , %s",super.getCccd(),super.getName(),super.getPhoneNumber(),getDayIn(),getNote());
//    }
//    public String noNote() {
//        return String.format("%s , %s , %s , %s",super.getCccd(),super.getName(),super.getPhoneNumber(),getDayIn());
//    }
}
