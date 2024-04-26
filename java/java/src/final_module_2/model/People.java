package final_module_2.model;

public class People extends Hospital{
    private String price;
    private String VIP;
    private String timeVIP;

    public People(int number, String id, String idPeopple, String name, String dayIn, String dayOut, String reason, String price) {
        super(number, id, idPeopple, name, dayIn, dayOut, reason);
        this.price = price;
    }
    public People(int number, String id, String idPeopple, String name, String dayIn, String dayOut, String reason, String VIP, String timeVIP) {
        super(number, id, idPeopple, name, dayIn, dayOut, reason);
        this.VIP = VIP;
        this.timeVIP = timeVIP;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVIP() {
        return VIP;
    }

    public void setVIP(String VIP) {
        this.VIP = VIP;
    }

    public String getTimeVIP() {
        return timeVIP;
    }

    public void setTimeVIP(String timeVIP) {
        this.timeVIP = timeVIP;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",super.getNumber(),super.getId(),super.getIdPeopple(),super.getName(),super.getDayIn(),super.getDayOut(),super.getReason(),getPrice(),getVIP(),getTimeVIP());
    }


    @Override
    public void type() {
        System.out.print("Normal People");
    }
}
