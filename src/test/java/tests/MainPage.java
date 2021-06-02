package tests;

import org.junit.Test;

public class MainPage extends BaseDriver {
    @Test
    public void tests() throws InterruptedException {
        new LoginPage().runTest();
        new SearchPage().runTest();
        new ProductPage().runTest();
    }
}
