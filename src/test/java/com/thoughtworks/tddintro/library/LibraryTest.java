package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */
    private Library library;
    private PrintStream printStream;
    private List<String> books;
    private DateTimeFormatter dateTimeFormatter;
    private DateTime time;


    @Before
    public void initialize(){
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
        library = new Library(books, printStream, dateTimeFormatter);
        time = new DateTime();
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        String title = "Book Title";
        books.add(title);
        library.listBooks();
        verify(printStream).println("Book Title");
        // add a verify statement here that shows that the book title was printed by to the printStream
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        // implement me
        library.listBooks();
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {

        BufferedReader reader = mock(BufferedReader.class);
        String title1 = "1";
        books.add(title1);
        String title2 = "2";
        books.add(title2);
        library.listBooks();
        when(reader.readLine()).thenReturn("1", "2");
        verify(printStream).println("1");
        verify(printStream).println("2");
        // implement me
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class

//        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
//        List<String> books = new ArrayList<>();
//        PrintStream printStream = mock(PrintStream.class);
//        DateTime time = new DateTime();
//        DateTimeFormatter dateTimeFormatter = mock(DateTimeFormatter.class);

        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);
        verify(printStream).println(contains("The current time is "));
        // add a verify here
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        // implement me
        when(dateTimeFormatter.print(time)).thenReturn("5PM");

        Library library = new Library(books, printStream, dateTimeFormatter);

        library.welcome(time);
        verify(printStream).println(contains("5PM"));
        // then move common test variables into a setup method
    }
}