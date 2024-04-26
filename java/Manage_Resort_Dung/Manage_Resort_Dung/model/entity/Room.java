package model.entity;

public class Room extends Services {
    private int roomId;
    private String bonusService;
    private AccompaniedService accompaniedService;
    public Room(String serviceName, String usableArea, double expense, int maxNumOfPeople,
            RentalType rentalType, int roomId, String bonusService, AccompaniedService accompaniedService) {
        super(serviceName, usableArea, expense, maxNumOfPeople, rentalType);
        this.roomId = roomId;
        this.bonusService = bonusService;
        this.accompaniedService = accompaniedService;
    }
    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public String getBonusService() {
        return bonusService;
    }
    public void setBonusService(String bonusService) {
        this.bonusService = bonusService;
    }
    public AccompaniedService getAccompaniedService() {
        return accompaniedService;
    }
    public void setAccompaniedService(AccompaniedService accompaniedService) {
        this.accompaniedService = accompaniedService;
    }
    @Override
    public String showInfor() {
        return "Room [roomId=" + roomId + ", bonusService=" + bonusService + ", accompaniedService="
                + accompaniedService + "]";
    }
    
}
