
import org.junit.jupiter.api.Test;
import ru.netology.product.Product;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


public class ProductRepositoryTest {
    Product first = new Product(1, "first", 20);
    Product second = new Product(2, "second", 30);
    Product third = new Product(3, "third", 40);

    @Test
    public void myTest1() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(2);

        Product[] actual = repo.findAll();
        Product[] expected = {first, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void myTest2() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(-2);
        });
    }
}
