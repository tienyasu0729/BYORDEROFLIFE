package test_retake_module_2.model;

public class People {
    private String name;
    private String day;
    private String sex;
    private String phoneNumber;

    public People(String name, String day, String sex, String phoneNumber) {
        this.name = name;
        this.day = day;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    @Override
//    public String toString() {
//        return "People{" +
//                "name='" + name + '\'' +
//                ", day='" + day + '\'' +
//                ", sex='" + sex + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
//    }
}
