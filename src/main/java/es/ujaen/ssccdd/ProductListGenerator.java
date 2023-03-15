package es.ujaen.ssccdd;

import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {

    public List<Product> generate(int tam) {
        List<Product> ret = new ArrayList<>();
        for (int i = 0; i < tam; i++) {
            ret.add(new Product("Product" + i, 10));
        }
        return ret;
    }
}
