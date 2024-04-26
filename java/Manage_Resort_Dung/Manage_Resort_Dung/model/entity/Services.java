package model.entity;

public class Services {
    private String serviceName;
    private String usableArea;
    private double expense;
    private int maxNumOfPeople;
    private RentalType rentalType;
    public Services(String serviceName, String usableArea, double expense, int maxNumOfPeople,
            RentalType rentalType) {
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.expense = expense;
        this.maxNumOfPeople = maxNumOfPeople;
        this.rentalType = rentalType;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getUsableArea() {
        return usableArea;
    }
    public void setUsableArea(String usableArea) {
        this.usableArea = usableArea;
    }
    public double getExpense() {
        return expense;
    }
    public void setExpense(double expense) {
        this.expense = expense;
    }
    public int getMaxNumOfPeople() {
        return maxNumOfPeople;
    }
    public void setMaxNumOfPeople(int maxNumOfPeople) {
        this.maxNumOfPeople = maxNumOfPeople;
    }
    public RentalType getRentalType() {
        return rentalType;
    }
    public void setRentalType(RentalType rentalType) {
        this.rentalType = rentalType;
    }
    public String showInfor() {
        return "Services [serviceName=" + serviceName + ", usableArea=" + usableArea + ", expense="
                + expense + ", maxNumOfPeople=" + maxNumOfPeople + ", rentalType=" + rentalType.getRentalTypeName()+" "+rentalType.getTime() + "]";
    }
    
}
