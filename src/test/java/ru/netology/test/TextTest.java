package ru.netology.test;

import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.pages.Elements;

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
        Elements elements = new Elements(driver);
        elements.textInput.sendKeys("Hello!");
        elements.changeTextButton.click();
        Assertions.assertEquals("Hello!", elements.newText.getText());
        elements.textInput.sendKeys(" ");
        elements.changeTextButton.click();
        Assertions.assertEquals("Hello!", elements.newText.getText());
    }

    @Test
    public void newActivityTest() {
        Elements elements = new Elements(driver);
        elements.textInput.sendKeys("Good Afternoon!");
        elements.newActivityBtn.click();
        Assertions.assertEquals("Good Afternoon!", elements.newActivityText.getText());
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
