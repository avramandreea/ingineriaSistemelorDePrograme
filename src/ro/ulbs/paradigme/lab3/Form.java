package ro.ulbs.paradigme.lab3;

public class Form {
    private String color;
    private static int counter = 0; // Camp static pentru a numara instantele

    public Form() {
        color = "white";
        counter++; // Incrementarea contorului la crearea unei instante
    }

    public Form(String color) {
        this.color = color;
        counter++; // Incrementarea contorului
    }

    public float getArea(){
        return 0.0f;
    }

    public static int getCounter() { // Getter pentru contor
        return counter;
    }

    @Override
    public String toString() {
        return "This form has the color: " + color;
    }

    public static void main(String[] args) {
        Form f1 = new Form();
        Form f2 = new Form("red");
        Form f3 = new Form("blue");

        System.out.println("Number of instances created: " + Form.getCounter());
    }
}
