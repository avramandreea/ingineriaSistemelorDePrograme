package ro.ulbs.paradigme.lab2;

public class Form {
    private String color;
    public Form() {
        color = "white";
    }
    public Form(String color) {
        this.color = color;
    }
    public float getArea(){
        return 0.0f;
    }

    @Override
    public String toString() {
        return "This form has the color: " + color;
    }
}
