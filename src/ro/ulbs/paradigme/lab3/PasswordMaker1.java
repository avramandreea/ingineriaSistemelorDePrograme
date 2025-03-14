package ro.ulbs.paradigme.lab3;

import java.util.Random;


public class PasswordMaker1 {
    private static final int MAGIC_NUMBER = new Random().nextInt(6) + 5; // Valoare intre 5 si 10
    private final String magicString;
    private final String name;

    public PasswordMaker1(String name) {
        this.name = name;
        this.magicString = StringRandomizer1.getRandomString(20); // Minim 20 caractere
    }

    public String getPassword() {
        Random random = new Random();
        String randomPart1 = StringRandomizer1.getRandomString(MAGIC_NUMBER);
        String randomPart2 = getRandomSubstring(magicString, 10);
        String nameLength = String.valueOf(name.length());
        int randomInt = random.nextInt(51); // Intre 0 si 50

        return randomPart1 + randomPart2 + nameLength + randomInt;
    }

    private String getRandomSubstring(String str, int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        return sb.toString();
    }

}
