package ro.ulbs.paradigme.lab3;

public class Main {
    public static void main(String[] args) {


        PasswordMaker1 pm1 = new PasswordMaker1();
        PasswordMaker1 pm2 = PasswordMaker1.getInstance();
        System.out.println("Generated Password: " + pm1.getPassword());
        System.out.println("Access Counter: " + PasswordMaker1.getAccessCounter());
        System.out.println("Generated Password: " + pm1.getPassword());
        System.out.println("Access Counter: " + PasswordMaker1.getAccessCounter());
    }
}
