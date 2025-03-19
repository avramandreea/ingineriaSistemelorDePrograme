package ro.ulbs.paradigme.lab3;

public class Main {
    public static void main(String[] args) {
        Form f1 = new Form();
        Form f2 = new Form("red");
        Form f3 = new Form("blue");

        System.out.println("Number of instances created: " + Form.getCounter());
    }
}
