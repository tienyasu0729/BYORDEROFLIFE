package test.thu;

public class Human implements Comparable<Human> {
    private String cccd;
    private String name;
    private int age;

    public Human(String id, String name, int age) {
        this.cccd = id;
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
        return "Human{" +
                "id=" + cccd +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // sắp xếp đối tượng theo cccd
    @Override
    public int compareTo(Human o) {
        char[] charThisID = this.cccd.toCharArray();
        char[] charOID = o.cccd.toCharArray();
        int returnCCCD = 0;
        for (int i = 0; i < 12; i++) {
            if (Character.getNumericValue(charThisID[i]) > Character.getNumericValue(charOID[i])){
                returnCCCD = 1;
                break;
            } else if (Character.getNumericValue(charThisID[i]) < Character.getNumericValue(charOID[i])){
                returnCCCD = -1;
                break;
            }
        }
        return returnCCCD;
    }
}
