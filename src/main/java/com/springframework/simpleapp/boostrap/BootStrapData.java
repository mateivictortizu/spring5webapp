package com.springframework.simpleapp.boostrap;

import com.springframework.simpleapp.domain.Author;
import com.springframework.simpleapp.domain.Book;
import com.springframework.simpleapp.domain.Publisher;
import com.springframework.simpleapp.repositories.AuthorRepository;
import com.springframework.simpleapp.repositories.BookRepository;
import com.springframework.simpleapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher p = new Publisher();
        p.setName("Editura ART");
        p.setCity("Iasi");
        p.setState("Romania");
        publisherRepository.save(p);

        Author eric = new Author("Eric","Evans");
        Book book = new Book("Book","12345");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(p);
        p.getBooks().add(book);
        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("JEE Development", "13456");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(p);
        p.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
    }
}
