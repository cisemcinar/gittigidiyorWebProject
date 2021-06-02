package tests;

import org.junit.Test;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    @Test
    public void runTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.get(loginUrl);

        setById("L-UserNameField", "testcisem@hotmail.com");
        setById("L-PasswordField", "cisem12345");
        clickBy(By.xpath("//input[@type='submit']"));
    }
}
