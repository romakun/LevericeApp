package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class OptionElements {
    String option = "//div[@class='popup-button__body']/label[text()='%s']";

    public void clickByOption(String optionName){
        By optionLocator = xpath(String.format(option, optionName));
        $(optionLocator).shouldBe(Condition.visible);
        $(optionLocator).click();
    }
}
