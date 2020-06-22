package pages;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class BasePage {

    public abstract BasePage openPage();

    public abstract BasePage isPageOpened();
}
