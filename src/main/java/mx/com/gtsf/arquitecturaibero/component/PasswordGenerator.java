package mx.com.gtsf.arquitecturaibero.component;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component("passwordGenerator")
public class PasswordGenerator {

    public String generatePassword() {
        int leftLimit = 49; // numeral '1'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}

