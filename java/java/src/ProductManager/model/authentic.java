package ProductManager.model;

public class authentic extends product{
    private int warrantyPeriod;

    public authentic(int id, String name, int price, String producer, int warrantyPeriod) {
        super(id, name, price, producer);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return "authentic{" +
                "warrantyPeriod=" + warrantyPeriod +
                "} " + super.toString();
    }
}
