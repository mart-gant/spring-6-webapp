package guru.springframework.spring6webapp.bootstrap;


import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.entity.Author;
import guru.springframework.spring6webapp.repository.AuthorRepository;
import guru.springframework.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public Bootstrap(AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) {

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Penguin Books");
        publisher1.setAddress("123 Penguin Lane");
        publisher1.setCity("New York");
        publisher1.setState("NY");
        publisher1.setZip("10001");
        publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("HarperCollins");
        publisher2.setAddress("456 Harper St");
        publisher2.setCity("Los Angeles");
        publisher2.setState("CA");
        publisher2.setZip("90001");
        publisherRepository.save(publisher2);

        Author author1 = new Author();
        author1.setFirstName("J.R.R.");
        author1.setLastName("Tolkien");
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setFirstName("Jane");
        author2.setLastName("Austen");
        authorRepository.save(author2);

        Author author3 = new Author();
        author3.setFirstName("George");
        author3.setLastName("Orwell");
        authorRepository.save(author3);

        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
    }
}
