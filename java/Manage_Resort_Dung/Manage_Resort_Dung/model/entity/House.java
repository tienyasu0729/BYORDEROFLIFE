package model.entity;

public class House extends Services {
    private int houseId;
    private String roomStandard;
    private String otherAdvantages;
    private int numberOfFloors;
    private AccompaniedService accompaniedService;
    public House(String serviceName, String usableArea, double expense, int maxNumOfPeople,
            RentalType rentalType, int houseId, String roomStandard, String otherAdvantages, int numberOfFloors,
            AccompaniedService accompaniedService) {
        super(serviceName, usableArea, expense, maxNumOfPeople, rentalType);
        this.houseId = houseId;
        this.roomStandard = roomStandard;
        this.otherAdvantages = otherAdvantages;
        this.numberOfFloors = numberOfFloors;
        this.accompaniedService = accompaniedService;
    }
    public int getHouseId() {
        return houseId;
    }
    public void setHouseId(int houseId) {
        this.houseId = houseId;
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
        return "House [houseId=" + houseId + ", roomStandard=" + roomStandard + ", otherAdvantages=" + otherAdvantages
                + ", numberOfFloors=" + numberOfFloors + ", accompaniedService=" + accompaniedService + "]";
    }
    
    
}
