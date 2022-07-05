package ru.netology.repository;

import ru.netology.product.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {

        int length = products.length + 1;
        Product[] tmp = new Product[length];
        //       for (int i = 0; i < products.length; i++) {
        //           tmp[i] = products[i];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastProduct = tmp.length - 1;
        tmp[lastProduct] = product;
        products = tmp;

    }

    public Product[] findAll() {return products;}

    public void removeById(int id) {
        Product productById = findById(id);
        if (productById == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }

        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

}
