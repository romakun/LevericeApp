package pages.messegerBarPage;

import lombok.extern.log4j.Log4j2;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class MessengerBarPage extends BasePage {
    private static final String FILTER_TRIGGERS_CSS = ".filter-trigger";
    private static final String NOT_SUBSCRIBED_CHANNELS = ".show-not-subscribed-channels";
    private static final String ARCHIVED_CHANNELS = ".show-archived-channels";
    private static final String FAVORITE_CHANNELS = ".show-favorite-channels";
    private static final String MATRIX = ".show-matrix";
    private static final String UNREAD_CHANNELS = ".show-unread-channels";
    private static final String COLLAPSE_ALL = ".collapse-all-icon";
    private static final String CHANNEL_URL = ".channel-url-icon";

    @Override
    public MessengerBarPage openPage() {
        log.info("Открываем messenger bar");
        isPageOpened();
        return this;
    }

    @Override
    public MessengerBarPage isPageOpened() {
        return null;
    }

    public MessengerBarPage openMessengerBar() {
        $(FILTER_TRIGGERS_CSS).click();
        return this;
    }

    public MessengerBarPage notSubscribedChannels() {
        $(NOT_SUBSCRIBED_CHANNELS).click();
        return this;
    }

    public MessengerBarPage archivedChannels() {
        $(ARCHIVED_CHANNELS).click();
        return this;
    }

    public MessengerBarPage favoriteChannels() {
        $(FAVORITE_CHANNELS).click();
        return this;
    }

    public MessengerBarPage priorityMatrix() {
        $(MATRIX).click();
        return this;
    }

    public MessengerBarPage channelsWithUnreadMessages() {
        $(UNREAD_CHANNELS).click();
        return this;
    }

    public MessengerBarPage collapseAllChanel() {
        $(COLLAPSE_ALL).click();
        return this;
    }

    public MessengerBarPage locateCurrentChanel() {
        $(CHANNEL_URL).click();
        return this;
    }
}
