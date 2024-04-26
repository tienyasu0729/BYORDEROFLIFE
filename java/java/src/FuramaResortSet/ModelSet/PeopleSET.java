package FuramaResortSet.ModelSet;

public abstract class PeopleSET {
    private String cccd;
    private String name;
    private int age;

    public PeopleSET(String cccd, String name, int age) {
        this.cccd = cccd;
        this.name = name;
        this.age = age;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "people{" +
                "cccd=" + cccd +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public abstract void move();
}
