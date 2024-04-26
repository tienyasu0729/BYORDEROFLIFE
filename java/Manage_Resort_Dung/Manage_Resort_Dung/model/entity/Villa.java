package model.entity;


public class Villa extends Services {
    private String villaId;
    private String roomStandard;
    private String otherAdvantages;
    private double poolArea;
    private int numberOfFloors;
    private AccompaniedService accompaniedService;
    public Villa(String serviceName, String usableArea, double expense, int maxNumOfPeople,
            RentalType rentalType, String villaId, String roomStandard, String otherAdvantages, double poolArea,
            int numberOfFloors, AccompaniedService accompaniedService) {
        super(serviceName, usableArea, expense, maxNumOfPeople, rentalType);
        this.villaId = villaId;
        this.roomStandard = roomStandard;
        this.otherAdvantages = otherAdvantages;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.accompaniedService = accompaniedService;
    }
    public String getVillaId() {
        return villaId;
    }
    public void setVillaId(String villaId) {
        this.villaId = villaId;
    }
    public String getRoomStandard() {
        return roomStandard;
    }
    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }
    public String getOtherAdvantages() {
        return otherAdvantages;
    }
    public void setOtherAdvantages(String otherAdvantages) {
        this.otherAdvantages = otherAdvantages;
    }
    public double getPoolArea() {
        return poolArea;
    }
    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public AccompaniedService getAccompaniedService() {
        return accompaniedService;
    }
    public void setAccompaniedService(AccompaniedService accompaniedService) {
        this.accompaniedService = accompaniedService;
    }
    @Override
    public String showInfor() {
        return "Villa [villaId=" + villaId + ", roomStandard=" + roomStandard + ", otherAdvantages=" + otherAdvantages
                + ", poolArea=" + poolArea + ", numberOfFloors=" + numberOfFloors + ", accompaniedService="
                + accompaniedService + "]";
    }
    
}
