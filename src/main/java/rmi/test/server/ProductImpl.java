package rmi.test.server;

/**
 * Created by User on 11.10.2018.
 */
public class ProductImpl implements Product {

    public ProductImpl(String n) {
        name = n;
    }

    public String getDescription() {
        return "I am a " + name + ". Buy me!";
    }

    private String name;
}

