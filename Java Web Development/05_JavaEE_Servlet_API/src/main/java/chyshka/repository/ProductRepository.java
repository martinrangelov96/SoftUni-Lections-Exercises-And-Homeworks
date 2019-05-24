package chyshka.repository;

import chyshka.domain.entities.Product;

public interface ProductRepository extends GenericRepository<Product, String> {

    Product findByName(String name);
}
