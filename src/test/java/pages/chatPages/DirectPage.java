package pages.chatPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class DirectPage extends BasePage {

    String userEmailLocator = "//div[@class='user-email' and contains(text(),'%s')]";
    String userInvitedTextLocator = "/../../div[contains(@class,'invited') and contains(text(),'User invited')]";
    private static final String SEARCH_INPUT_CSS = "[placeholder='Search']";

    @Override
    public DirectPage openPage() {
        return null;
    }

    @Override
    public DirectPage isPageOpened() {
        return null;
    }

    public DirectPage checkInviteUser(String userEmail){
        $(SEARCH_INPUT_CSS).setValue(userEmail);
        By userInvitedLocator = xpath(String.format(userEmailLocator, userEmail) + userInvitedTextLocator);
        try {
            $(userInvitedLocator).shouldBe(Condition.visible);
        } catch (ElementNotFound e){
            Assert.fail("Пользователь не заинвайчен");
        }
        return this;
    }
}
