package model.entity;

public class WorkingParts {
    private int id;
    private String workingPartsName;
    public WorkingParts(int id, String workingPartsName) {
        this.id = id;
        this.workingPartsName = workingPartsName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getWorkingPartsName() {
        return workingPartsName;
    }
    public void setWorkingPartsName(String workingPartsName) {
        this.workingPartsName = workingPartsName;
    }
    @Override
    public String toString() {
        return "WorkingParts [id=" + id + ", workingPartsName=" + workingPartsName + "]";
    }
    
    
}
