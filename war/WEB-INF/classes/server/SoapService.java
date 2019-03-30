/**
 * @author Cervantes Hernandez
 */
package server;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@WebService(serviceName = "SOAPSoapService")
public class SoapService {
    private TreeMap<String,Double> soaps;


    public SoapService(){
        soaps = new TreeMap<>();
        soaps.put("Dial", 2.97);
        soaps.put("Dove", 6.49);
        soaps.put("Irish Spring", 4.39);
        soaps.put("Lever", 6.19);
        soaps.put("Zest", 3.00);

    }
    @WebMethod(exclude = true)
    private Map.Entry getMaxEntryInMap(Map<String,Double> hm) {
        Map.Entry<String,Double> maxEntry = null;
        for (Map.Entry<String,Double> entry : hm.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }
    @WebMethod(exclude = true)
    private Map.Entry getMinEntryInMap(Map<String,Double> hm) {
        Map.Entry<String,Double> minEntry = null;
        for (Map.Entry<String,Double> entry : hm.entrySet()) {
            if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0) {
                minEntry = entry;
            }
        }
        return minEntry;
    }
    @WebMethod(exclude = true)
    private String[] getMapKeysAsStringArray(Map<String,Double> hm){
        Set<String> keys = hm.keySet();
        return keys.toArray(new String[keys.size()]);
    }

    /**
     * Takes no arguments and returns a list of the methods contained in the service.
     * @return String[]
     */
    @WebMethod(operationName = "getMethods")
    public String[] getMethods(){
        String[] methods = new String[5];
        methods[0] = "getPrice";
        methods[1] = "getProducts";
        methods[2] = "getCheapest";
        methods[3] = "getCostliest";
        methods[4] = "getMethods";
        return methods;
    }

    /**
     * 	Takes a string denoting the product name and returns a double representing the product price.
     * @param product Product Name
     * @return Double
     */
    @WebMethod(operationName = "getPrice")
    public Double getPrice(String product){
        return soaps.get(product);
    }

    /**
     * Takes no arguments and returns a list of the known products.
     * @return String[]
     */
    @WebMethod(operationName = "getProducts")
    public String[] getProducts(){
        return getMapKeysAsStringArray(soaps);
    }

    /**
     * Takes no arguments and returns the name of the least expensive product.
     * @return string
     */
    @WebMethod(operationName = "getCheapest")
    public String getCheapest(){
        return (String) this.getMinEntryInMap(soaps).getKey();
    }

    /**
     * 	Takes no arguments and returns the name of the most expensive product.
     * @return string
     */
    @WebMethod(operationName = "getCostliest")
    public String getCostliest(){
        return (String) this.getMaxEntryInMap(soaps).getKey();
    }

}
