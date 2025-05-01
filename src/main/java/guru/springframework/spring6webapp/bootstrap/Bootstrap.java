package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final PublisherRepository publisherRepository;

    public Bootstrap(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting Bootstrap...");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Example Publisher");
        publisher.setAddress("123 Main St");
        publisher.setCity("Example City");
        publisher.setState("EX");
        publisher.setZip("12345");

        publisherRepository.save(publisher);

        System.out.println("Number of publishers in database: " + publisherRepository.count());
    }
}
