package javazon2;

public class LineItem {

    private Product jvzProduct;
    private int jvzQuantity;

    public LineItem(Product aProduct, int aQuantity) {
        jvzProduct = aProduct;
        jvzQuantity = aQuantity;
    }

    public Product getJvzProduct() {
        //change null to correct value
        //Write the code necessary for this method
        return jvzProduct;
    }

    public void setJvzProduct(Product jvzProduct) {
        //Write the code necessary for this method
        this.jvzProduct = jvzProduct;
    }

    public int getJvzQuantity() {
        //change 0 to correct value
        //Write the code necessary for this method
        return jvzQuantity;
    }

    public void setJvzQuantity(int jvzQuantity) {
        //Write the code necessary for this method
        this.jvzQuantity = jvzQuantity;
    }

    public double getJvzLineTotal() {
        //change 0 to correct value
        //Write the code necessary for this method
        //This method returns the total for each line
        //the total is the quantity x price of the product
        return jvzQuantity * jvzProduct.getPrice();
    }
}
