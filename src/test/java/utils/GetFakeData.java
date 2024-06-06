package utils;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class GetFakeData {
    public static String generateFakeData(String fakeData){
        Faker faker=new Faker();
        String data="";
        switch (fakeData) {
            case "firstName" -> data = faker.name().firstName().toLowerCase();
            case "lastName" -> data = faker.name().lastName().toLowerCase();
            case "email" -> data = faker.name().firstName().toLowerCase() + faker.number().digits(3) + "@gmail.com";
            case "password" -> {
                String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
                data = RandomStringUtils.random(8, characters);
            }
            case "username" -> data = "auto_" + faker.lorem().word().toLowerCase() + "_" + faker.number().digits(3);
            case "birthDate" -> {
                // Generate a random date between now and 30 years ago
                Date randomDate = faker.date().past(10 * 365, TimeUnit.DAYS);

                // Convert Date to LocalDateTime
                LocalDateTime localDateTime = randomDate.toInstant().atZone(ZoneOffset.UTC).toLocalDateTime();
                data = String.valueOf(localDateTime);
            }
            case "phoneNumber" -> data = (String.valueOf(faker.number().digits(10)));
            case "randomNumber" -> data = String.valueOf(faker.number().numberBetween(00, 10));
            case "birthMonth" -> data = String.valueOf(faker.number().numberBetween(00, 12));
            case "birthYear" -> data = String.valueOf(faker.date().birthday());
            default -> logger.Loggers.info("invalid key");
        }
        return data;
    }
}
