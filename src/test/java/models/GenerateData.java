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

    public String generateRandomEmail() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return emailAddress = fakeValuesService.bothify("????????##@mailinator.com");
    }

    public String generateRandomFolder() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return folderName = fakeValuesService.bothify("New Folder ###");
    }

    public String generateRandomTopic() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return topicName = fakeValuesService.bothify("New Topic ###");
    }

    public String generateRandomChannel() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return channelName = fakeValuesService.bothify("New Channel ###");
    }

    public String generateRandomUserFirstName() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return userFName = fakeValuesService.bothify("User##");
    }

    public String generateRandomUserLastName() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return userLName = fakeValuesService.bothify("?????");
    }
}