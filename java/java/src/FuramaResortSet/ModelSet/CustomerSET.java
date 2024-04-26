package FuramaResortSet.ModelSet;

public class CustomerSET extends PeopleSET implements Comparable<CustomerSET>{
    private String phoneNumBer;

    public CustomerSET(String cccd, String name, int age, String phoneNumBer) {
        super(cccd, name, age);
        this.phoneNumBer = phoneNumBer;
    }

    public String getPhoneNumBer() {
        return phoneNumBer;
    }

    public void setPhoneNumBer(String phoneNumBer) {
        this.phoneNumBer = phoneNumBer;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s", super.getCccd(),super.getName(), super.getAge(), phoneNumBer );
    }

    @Override
    public int compareTo(CustomerSET customerSET) {
        char[] charThisGetCCCD = this.getCccd().toCharArray();
        char[] charEmployeeCCCD = customerSET.getCccd().toCharArray();
        int returnCCCD = 0;
        for (int i = 0; i < 12; i++) {
            if (Character.getNumericValue(charThisGetCCCD[i]) > Character.getNumericValue(charEmployeeCCCD[i])){
                returnCCCD = 1;
                break;
            } else if (Character.getNumericValue(charThisGetCCCD[i]) < Character.getNumericValue(charEmployeeCCCD[i])){
                returnCCCD = -1;
                break;
            }
        }
        return returnCCCD;
    }
    @Override
    public void move() {
        System.out.println("Di chuyển bằng xe");
    }
}
