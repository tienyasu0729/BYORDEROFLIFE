package tiem_cam_do_tien_thanh.model;

public class MobilePhone extends Human{
    private String product;
    private int price;
    private String dayIn;
    private String dueDay;
    private String dayOut;

    public MobilePhone(String name, String phoneNumber, String product, int price, String dayIn, String dueDay, String dayOut) {
        super(name, phoneNumber);
        this.product = product;
        this.price = price;
        this.dayIn = dayIn;
        this.dueDay = dueDay;
        this.dayOut = dayOut;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDayIn() {
        return dayIn;
    }

    public void setDayIn(String dayIn) {
        this.dayIn = dayIn;
    }

    public String getDueDay() {
        return dueDay;
    }

    public void setDueDay(String dueDay) {
        this.dueDay = dueDay;
    }

    public String getDayOut() {
        return dayOut;
    }

    public void setDayOut(String dayOut) {
        this.dayOut = dayOut;
    }
}
