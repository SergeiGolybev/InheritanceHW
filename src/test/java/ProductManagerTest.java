import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.Repository;

public class ProductManagerTest {

    @Test
    public void shouldFindAll() {

        Product book1 = new Book(1, "Capital",1000, "K.Marks");
        Product smartphone1 = new Smartphone(2,"N80", 14000, "Nokia");
        Product book2 = new Book(3, "Red Sails", 3000, "A.Green");


        Repository repository = new Repository();
        repository.add(book1);
        repository.add(smartphone1);
        repository.add(book2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, smartphone1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        Product book1 = new Book(1, "Capital",1000, "K.Marks");
        Product smartphone1 = new Smartphone(2,"N80", 14000, "Nokia");
        Product book2 = new Book(3, "Red Sails", 3000, "A.Green");

        Repository repository = new Repository();
        repository.add(book1);
        repository.add(smartphone1);
        repository.add(book2);
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchBy() {

        Product book1 = new Book(1, "Capital",1000, "K.Marks");
        Product smartphone1 = new Smartphone(2,"N80", 14000, "Nokia");
        Product book2 = new Book(3, "Red Sails", 3000, "A.Green");

        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);
        repository.add(book1);
        repository.add(smartphone1);
        repository.add(book2);
        Product[] actual = manager.searchBy("Red Sails");
        Product[] expected = {book2};
        Assertions.assertArrayEquals(expected, actual);
    }
}
