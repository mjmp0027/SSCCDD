package es.ujaen.ssccdd;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer> {
    private final Integer numero;

    public FactorialCalculator(Integer valor) {
        this.numero = valor;
    }

    @Override
    public Integer call() throws Exception {
        int num, result;
        num = numero;
        result = 2;
        if((num==0)||(num==1)){
            result = 1;
        }else{
            for (int i = 2; i <= numero; i++) {
                result = result * i;
                Thread.sleep(20);
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + result + "\n");
        return result;
    }
}
