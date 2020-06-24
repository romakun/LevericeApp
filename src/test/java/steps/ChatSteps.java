package steps;

import pages.chatPages.ChatPage;

public class ChatSteps {

    ChatPage chatPage;

    public ChatSteps () {
        chatPage = new ChatPage();
    }

    public void sendMessage (String message) {
        chatPage.openPage().sendMessage(message);
    }

    public void editMessage (String message) {
        chatPage.openPage().editMessage(message);
    }

    public void sendEmoji () {
        chatPage.openPage().sendEmoji();
    }

    public void deleteMessage () {
        chatPage.openPage().deleteMessage();
    }

    public void quoteMessage () {
        chatPage.openPage().quoteMessage();
    }
}
