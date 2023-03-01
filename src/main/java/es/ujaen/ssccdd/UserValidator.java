package es.ujaen.ssccdd;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
    private final String name;

    public UserValidator(String name) {
        this.name = name;
    }

    public boolean validate(String name, String password) {
        Random random = new Random();

        try {
            long duration = (long) (Math.random() * 10);
            System.out.println("Validator: " + name + " clave: " + password + ", Validating a user during " + duration + " seconds\n");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }
        return random.nextBoolean();
    }

    public String getName() {
        return name;
    }
}
