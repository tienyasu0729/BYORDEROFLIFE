class Biz extends Student {
    private double accountingScore;
    private double marketingScore;

    public Biz(String fullName, String address, int age, double accountingScore, double marketingScore) {
        super(fullName, address, age);
        this.accountingScore = accountingScore;
        this.marketingScore = marketingScore;
    }

    @Override
    public void calculateAverage() {
        setAverage((2 * accountingScore + marketingScore) / 3);
    }

    @Override
    public void printInformation() {
        super.printInformation();
        System.out.println("Điểm Kế Toán: " + accountingScore);
        System.out.println("Điểm Marketing: " + marketingScore);
    }
}
