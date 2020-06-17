package models;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class GenerateEmail {

    String emailAddress;

    public String generateRandomEmail() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return emailAddress = fakeValuesService.bothify("????????##@mailinator.com");
    }
}