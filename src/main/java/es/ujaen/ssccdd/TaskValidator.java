package es.ujaen.ssccdd;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {

    private final UserValidator validator;
    private final String  nombreUsuario;
    private final String clave;

    public TaskValidator(UserValidator validator, String nombreUsuario, String clave) {
        this.validator = validator;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }

    @Override
    public String call() throws Exception {
        if (!validator.validate(this.nombreUsuario, this.clave)) {
            System.out.println(": The user " + validator.getName() + " has not been found\n");
            throw new Exception("Error validating user");
        }
        System.out.println(": The user " + validator.getName() + " has been found\n");
        return validator.getName();
    }
}
