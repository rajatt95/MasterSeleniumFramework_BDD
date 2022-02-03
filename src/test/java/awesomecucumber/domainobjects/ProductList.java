package awesomecucumber.domainobjects;

public class ProductList {
    private Product[] products;

    public void addAllProducts(Product[] products){
        this.products = products;
    }

    public Product getProductByName(String name) throws Exception {
        for(Product product: products){
            if(product.getName().equals(name)){
                return product;
            }
        }
        throw new Exception("Product with name: " + name + " not found");
    }
}
