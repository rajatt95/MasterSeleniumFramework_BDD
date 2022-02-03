package awesomecucumber.context;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Cookies;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.domainobjects.ProductList;
import awesomecucumber.utils.JacksonUtils;

public class TestContext {
    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;
    public ProductList productList = new ProductList();
    public Product product;

    /**
	 * Dependency Injection using Pico container
	 */
    public TestContext() throws IOException {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
        productList.addAllProducts(JacksonUtils.deserializeJson("products.json", Product[].class));
    }
}
