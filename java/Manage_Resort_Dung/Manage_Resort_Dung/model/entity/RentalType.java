package model.entity;

public class RentalType {
    private int id;
    private String rentalTypeName;
    private String time;
    public RentalType(int id, String rentalTypeName, String time) {
        this.id = id;
        this.rentalTypeName = rentalTypeName;
        this.time = time;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRentalTypeName() {
        return rentalTypeName;
    }
    public void setRentalTypeName(String rentalTypeName) {
        this.rentalTypeName = rentalTypeName;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "RentalType [id=" + id + ", rentalTypeName=" + rentalTypeName + ", time=" + time + "]";
    }
    
    
}
