package ProductManager.model;

public class handGoods extends product{
    private String countryWarrantyPeriod;

    public handGoods(int id, String name, int price, String producer, String countryWarrantyPeriod) {
        super(id, name, price, producer);
        this.countryWarrantyPeriod = countryWarrantyPeriod;
    }

    public String getCountryWarrantyPeriod() {
        return countryWarrantyPeriod;
    }

    public void setCountryWarrantyPeriod(String countryWarrantyPeriod) {
        this.countryWarrantyPeriod = countryWarrantyPeriod;
    }

    @Override
    public String toString() {
        return "handGoods{" +
                "countryWarrantyPeriod='" + countryWarrantyPeriod + '\'' +
                "} " + super.toString();
    }
}
