package ro.ulbs.paradigme.lab3;

import java.util.Random;

public class PasswordMaker1 {
    private static final int MAGIC_NUMBER = new Random().nextInt(6) + 5;
    private static final String magicString = StringRandomizer1.generateRandomString(20);
    private static PasswordMaker1 instance;
    private static int instanceCounter = 0;
    private final String name;

    private PasswordMaker1(String name) {
        this.name = name;
    }

    public static synchronized PasswordMaker1 getInstance(String name) {
        if (instance == null) {
            instance = new PasswordMaker1(name);
        }
        instanceCounter++;
        return instance;
    }

    public static int getInstanceCounter() {
        return instanceCounter;
    }

    public String getPassword() {
        String randomPart = StringRandomizer1.generateRandomString(MAGIC_NUMBER);
        String randomMagicPart = StringRandomizer1.generateRandomString(10);
        int randomNumber = new Random().nextInt(51);
        return randomPart + randomMagicPart + name.length() + randomNumber;
    }
}
