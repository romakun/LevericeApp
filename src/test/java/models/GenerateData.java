package models;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class GenerateData {

    String emailAddress;
    String folderName;
    String channelName;
    String topicName;
    String userFName;
    String userLName;

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public String generateRandomEmail() {
        return emailAddress = fakeValuesService.bothify("????????##@mailinator.com");
    }

    public String generateRandomFolder() {
        return folderName = fakeValuesService.bothify("New Folder ###");
    }

    public String generateRandomTopic() {
        return topicName = fakeValuesService.bothify("New Topic ###");
    }

    public String generateRandomChannel() {
        return channelName = fakeValuesService.bothify("New Channel ###");
    }

    public String generateRandomUserFirstName() {
        return userFName = fakeValuesService.bothify("User##");
    }

    public String generateRandomUserLastName() {
        return userLName = fakeValuesService.bothify("?????");
    }
}