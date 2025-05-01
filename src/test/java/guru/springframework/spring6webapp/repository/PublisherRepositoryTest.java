package guru.springframework.spring6webapp.repository;

import guru.springframework.spring6webapp.domain.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    void testSavePublisher() {
        Publisher publisher = new Publisher();
        publisher.setPublisherName("Test Publisher");
        publisher.setAddress("456 Elm St");
        publisher.setCity("Test City");
        publisher.setState("TS");
        publisher.setZip("67890");

        Publisher savedPublisher = publisherRepository.save(publisher);

        assertThat(savedPublisher).isNotNull();
        assertThat(savedPublisher.getId()).isNotNull();
        assertThat(savedPublisher.getPublisherName()).isEqualTo("Test Publisher");
    }
}
