import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library;
    Book book1;

    @Before
    public void before(){
        library = new Library(5);
        book1 = new Book("How to Java", "Ally M", "Computing");
    }

    @Test
    public void startsAtZeroBooks(){
        //Given there is a library
        assertNotNull(library);
        //When
        //Then the book stock size is 0
        assertEquals(0, library.stockCount());
    }

    @Test
    public void canAddBook__notFull(){
        //Given there is a library
        assertNotNull(library);
        //AND there is a book
        assertNotNull(book1);
        //When a book is added to the library
        library.addBook(book1);
        //Then the book stock count is 1
        assertEquals(1, library.stockCount());
    }

    @Test
    public void canAddBook__full(){
        //Given there is a library
        assertNotNull(library);
        //AND there is a book
        assertNotNull(book1);
        //AND 5 books are added to the library
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        //When another book is added to the library
        library.addBook(book1);
        //Then the book stock count stays at 5
        assertEquals(5, library.stockCount());
    }

    @Test
    public void checksIfSpaceToAddBook__hasSpace(){
        //Given there is a library
        assertNotNull(library);
        //When no books have been added
        //Then the library has space to add books
        assertTrue(library.hasSpace());
    }

    @Test
    public void checksIfSpaceToAddBook__full(){
        //Given there is a library
        assertNotNull(library);
        //AND there is a book
        assertNotNull(book1);
        //When 5 books are added
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        //Then the library has no space to add books
        assertFalse(library.hasSpace());
    }

    @Test
    public void hasCapacity(){
        //Given there is a library
        assertNotNull(library);
        //When
        //Then the capacity of books is 10
        assertEquals(5, library.getCapacity());
    }
}
