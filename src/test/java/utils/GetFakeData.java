package utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GetFakeData {
    public static String generateFakeFirstName(){
        Faker faker=new Faker();
        return faker.name().firstName().toLowerCase();
    }
    public static String generateFakeLastName(){
        Faker faker=new Faker();
        return faker.name().lastName().toLowerCase();
    }
    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.name().firstName().toLowerCase() + faker.number().digits(3) + "@gmail.com";
    }
    public static String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        return RandomStringUtils.random(8, characters);
    }
    public static String generateUsername() {
        Faker faker = new Faker();
        return "auto_" + faker.lorem().word().toLowerCase() + "_" + faker.number().digits(3);
    }
    public static LocalDateTime generateRandomDates(){
        Faker faker = new Faker();

        // Generate a random date between now and 30 years ago
        Date randomDate = faker.date().past(10 * 365, TimeUnit.DAYS);

        // Convert Date to LocalDateTime
        LocalDateTime localDateTime = randomDate.toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
        return localDateTime;
    }
    public static String generatePhoneNumber(){
        Faker faker = new Faker();
        return (String.valueOf(faker.number().digits(10)));
    }
    public static int generateRandomNumber(){
        Faker faker=new Faker();
        return faker.number().numberBetween(00, 10);
    }

    public static int generateRandomMonth() {
        Faker faker=new Faker();
        return faker.number().numberBetween(00,12);
    }

    public static Date generateRandomYear() {
        Faker faker=new Faker();
        return faker.date().birthday();
    }
}
