package server;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SoapServiceTest {
    private SoapService CuT;
    private String[] array_for_get_products;

    @Before
    public void setUp() throws Exception {
        CuT = new SoapService();

        array_for_get_products = new String[5];
        array_for_get_products[0] = "Dial";
        array_for_get_products[1] = "Dove";
        array_for_get_products[2] = "Irish Spring";
        array_for_get_products[3] = "Lever";
        array_for_get_products[4] = "Zest";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMethods() {
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(new Double(6.49) ,CuT.getPrice("Dove"));
        Assert.assertEquals(new Double(4.39) ,CuT.getPrice("Irish Spring"));
        Assert.assertEquals(new Double(2.97) ,CuT.getPrice("Dial"));
        Assert.assertEquals(new Double(6.19) ,CuT.getPrice("Lever"));
        Assert.assertEquals(new Double(3.00) ,CuT.getPrice("Zest"));
    }

    @Test
    public void getProducts() {
        Assert.assertArrayEquals(array_for_get_products, CuT.getProducts());
    }

    @Test
    public void getCheapest() {
        Assert.assertEquals("Dial",CuT.getCheapest());
    }

    @Test
    public void getCostliest() {
        Assert.assertEquals("Dove",CuT.getCostliest());
    }

}