package awesomecucumber.customtype;

import awesomecucumber.domainobjects.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String, String> entry){
       
    	/**
    	 * firstname, lastname, address_line1, ........ are coming from feature files
    	 * 
    	 */
    	return new BillingDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }
}
