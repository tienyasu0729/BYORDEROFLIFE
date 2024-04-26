class CNTT extends Student {
    private double javaScore;
    private double cssScore;

    public CNTT(String fullName, String address, int age, double javaScore, double cssScore) {
        super(fullName, address, age);
        this.javaScore = javaScore;
        this.cssScore = cssScore;
    }

    @Override
    public void calculateAverage() {
        setAverage((3 * javaScore + cssScore) / 4);
    }

    @Override
    public void printInformation() {
        super.printInformation();
        System.out.println("Điểm Java: " + javaScore);
        System.out.println("Điểm CSS: " + cssScore);
    }
}

