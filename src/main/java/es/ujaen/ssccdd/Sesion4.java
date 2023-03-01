package es.ujaen.ssccdd;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sesion4 {

    public static void main(String[] args) {
        String usuario = "Manuel";
        String clave = "clave";
        UserValidator validator1 = new UserValidator("LDAP");
        UserValidator validator2 = new UserValidator("Database");
        TaskValidator taskValidator1 = new TaskValidator(validator1, usuario, clave);
        TaskValidator taskValidator2 = new TaskValidator(validator2, usuario, clave);

        List<TaskValidator> validatorList = new ArrayList<>();
        validatorList.add(taskValidator1);
        validatorList.add(taskValidator2);

        ExecutorService executor = Executors.newCachedThreadPool();
        String result;
        try {
            result = executor.invokeAny(validatorList);
            System.out.println("Main: Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("Main: End of the execution\n");

    }
}