/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework (https://www.udemy.com/course/cucumber-bdd-masterclass/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

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
