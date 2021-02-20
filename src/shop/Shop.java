package shop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Shop{
    private Map<Integer, Product> productList = new LinkedHashMap<>();

    public Shop() {
    }

    public void add(Product product) throws ExceptionDuplicationProduct {
        if(!productList.containsKey(product.getId())) {
            productList.put(product.getId(), product);
        } else {
            throw new ExceptionDuplicationProduct(product.getId());
        }
    }

    public ArrayList getAll() {
        ArrayList<Product> list = new ArrayList<>(productList.values());
        return list;
    }

    public void remove(int id) throws ExceptionProductNotFound {
        if (productList.remove(id) == null) {
            throw new ExceptionProductNotFound(id);
        }
    }

    public void edit(Product product) throws ExceptionProductNotFound {

        if (productList.containsKey(product.getId())) {
            productList.put(product.getId(), product);
        } else {
            throw new ExceptionProductNotFound(product.getId());
        }
    }
}