package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class WorkSpaceChatElements {

    String elementLocator = "//div[contains(@class,'channel-node')]//*[contains(text(),'%s')]";

    public void clickByElement(String elementName){
        By elementXpath = xpath(String.format(elementLocator, elementName));
        $(elementXpath).shouldBe(Condition.visible);
        $(elementXpath).click();
    }
}
