package pages;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

@Log4j2
public abstract class BasePage {

    public abstract BasePage openPage();

    public abstract BasePage isPageOpened();

    public SelenideElement $(By element) {
        String script = "arguments[0].style.border='3px solid red'";
        try {
            Selenide.$(element).shouldBe(Condition.visible);
            Selenide.executeJavaScript(script, Selenide.$(element));
            return Selenide.$(element);
        } catch (ElementNotFound e) {
            Assert.fail("Не найден элемент " + element);
            return null;
        }
    }

    public SelenideElement $(By element, String logMessage) {
        $(element);
        log.info(logMessage);
        return Selenide.$(element);
    }

    public SelenideElement $(String element) {
        String script = "arguments[0].style.border='3px solid red'";
        try {
            Selenide.$(element).shouldBe(Condition.visible);
            Selenide.executeJavaScript(script, Selenide.$(element));
            return Selenide.$(element);
        } catch (ElementNotFound e) {
            Assert.fail("Не найден элемент " + element);
            return null;
        }
    }

    public SelenideElement $(String element, String logMessage) {
        log.info(logMessage);
        $(element);
        return Selenide.$(element);

    }

    public ElementsCollection $$(String elements, String logMessage) {
        log.info(logMessage);
        return Selenide.$$(elements);
    }

    public SelenideElement $$(String elements, int elementNumber, String logMessage) {
        log.info(logMessage);
        String script = "arguments[0].style.border='3px solid red'";
        List<SelenideElement> listElements = Selenide.$$(elements);
        try {
            Selenide.executeJavaScript(script, listElements.get(elementNumber));
            return listElements.get(elementNumber);
        } catch (ElementNotFound e) {
            Assert.fail("Не найден элемент " + listElements.get(elementNumber));
            return null;
        }
    }
}
