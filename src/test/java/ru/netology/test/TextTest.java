package ru.netology.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TextTest {

    private AndroidDriver driver;

    @BeforeAll
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Nova");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\user\\StudioProjects\\lecture\\mqa-homeworks\\2.2 UI Automator\\sample\\app\\build\\intermediates\\apk\\debug\\app-debug.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void emptyTextTest() {
        MobileElement el3 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el3.click();
        el3.sendKeys("Hello!");
        MobileElement el4 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el4.click();
        MobileElement e19 = (MobileElement) driver.findElementById("textToBeChanged");
        Assertions.assertEquals("Hello!", e19.getText());

        MobileElement el5 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el5.click();
        el5.sendKeys(" ");
        MobileElement el6 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonChange");
        el6.click();
        MobileElement e20 = (MobileElement) driver.findElementById("textToBeChanged");
        Assertions.assertEquals(e19.getText(), e20.getText());

    }

    @Test
    public void newActivityTest() {
        MobileElement el7 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/userInput");
        el7.click();
        el7.sendKeys("Good Afternoon!");
        MobileElement el8 = (MobileElement) driver.findElementById("ru.netology.testing.uiautomator:id/buttonActivity");
        el8.click();
        MobileElement e21 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.TextView");
        Assertions.assertEquals("Good Afternoon!", e21.getText());
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
