package com.example.SpringFramework5.bootstrap;

import com.example.SpringFramework5.model.PublisherRepository;
import com.example.SpringFramework5.repository.AuthorRepository;
import com.example.SpringFramework5.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import com.example.SpringFramework5.model.Author;
import com.example.SpringFramework5.model.Book;
import com.example.SpringFramework5.model.Publisher;

@Configuration
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
         initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);


        Author felix = new Author("Felix", "Laura");
        Book ddd = new Book("Domain Driven Design", "12345", publisher);

        felix.getBooks().add(ddd);
        ddd.getAuthors().add(felix);

        authorRepository.save(felix);
        bookRepository.save(ddd);

        Author luis = new Author("Luis", "Laura");
        Book noEJB = new Book("J2EE Development without EJB","23234", publisher);

        luis.getBooks().add(noEJB);
        noEJB.getAuthors().add(luis);

        authorRepository.save(luis);
        bookRepository.save(noEJB);
    }
}
