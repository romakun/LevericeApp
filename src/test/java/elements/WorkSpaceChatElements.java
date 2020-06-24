package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class WorkSpaceChatElements {

    String element = "//div[contains(@class,'channel-node')]//*[contains(text(),'%s')]";
    String elementToggle = "/../../..//div[@class='group-toggle__svg']";
    String elementMutedIcn = "/../..//div[@class='muted-channel-icon']";
    String elementSettingsIcon = "/../../..//div[@class='channel-settings-icon']";

    public void clickByElement(String elementName){
        By elementLocator = xpath(String.format(element, elementName));
        $(elementLocator).shouldBe(Condition.visible);
        $(elementLocator).click();
    }

    public void rightClickByElement(String elementName){
        By elementLocator = xpath(String.format(element, elementName));
        $(elementLocator).shouldBe(Condition.visible);
        $(elementLocator).contextClick();
    }

    public void toggleElement(String elementName){
        By elementLocator = xpath(String.format(element, elementName) + elementToggle);
        $(elementLocator).shouldBe(Condition.visible);
    }

    public boolean findElementMutedIcon(String elementName) {
        By elementLocator = xpath(String.format(element, elementName) + elementMutedIcn);
        return $(elementLocator).isDisplayed();
    }

    public void openElementSettingsIcon(String elementName) {
        By elementLocator = xpath(String.format(element, elementName) + elementSettingsIcon);
        $(elementLocator).click();
    }
}
