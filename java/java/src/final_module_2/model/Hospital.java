package final_module_2.model;

public abstract class Hospital {
    private int number;
    private String id;
    private String idPeopple;
    private String name;
    private String dayIn;
    private String dayOut;
    private String reason;

    public Hospital(int number, String id, String idPeopple, String name, String dayIn, String dayOut, String reason) {
        this.number = number;
        this.id = id;
        this.idPeopple = idPeopple;
        this.name = name;
        this.dayIn = dayIn;
        this.dayOut = dayOut;
        this.reason = reason;
    }

    public String getIdPeopple() {
        return idPeopple;
    }

    public void setIdPeopple(String idPeopple) {
        this.idPeopple = idPeopple;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayIn() {
        return dayIn;
    }

    public void setDayIn(String dayIn) {
        this.dayIn = dayIn;
    }

    public String getDayOut() {
        return dayOut;
    }

    public void setDayOut(String dayOut) {
        this.dayOut = dayOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "number=" + number +
                ", id='" + id + '\'' +
                ", idPeopple='" + idPeopple + '\'' +
                ", name='" + name + '\'' +
                ", dayIn='" + dayIn + '\'' +
                ", dayOut='" + dayOut + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    public abstract void type();
}
