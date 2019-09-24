import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library;
    Book book1;
    Book book2;
    Borrower borrower1;

    @Before
    public void before(){
        library = new Library(5);
        book1 = new Book("How to Java", "Ally M", "Computing");
        book2 = new Book("How to Java2", "Ally M", "Computing");
        borrower1 = new Borrower();

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

    @Test
    public void canRemoveBook__bookExists(){
        //Given there is a library
        assertNotNull(library);
        //AND there is a book
        assertNotNull(book1);
        //AND a book is added to the library
        library.addBook(book1);
        //When a book is removed
        library.removeBook(book1);
        //Then the library's stock count is 0
        assertEquals(0, library.stockCount());
    }

    @Test
    public void canRemoveBook__bookDoesNotExist(){
        //Given there is a library
        assertNotNull(library);
        //AND a book is added to the library
        library.addBook(book1);
        //When a non-existent book is removed
        library.removeBook(book2);
        //Then the library's stock count is still 1
        assertEquals(1, library.stockCount());
    }

    @Test
    public void canCheckOutBook__bookExists(){
        //Given there is a library
        assertNotNull(library);
        //AND there is a book
        assertNotNull(book1);
        //AND there is a borrower
        assertNotNull(borrower1);
        //AND the book is in the library stock
        library.addBook(book1);
        //When the library checks out the book to a borrower
        library.checkOut(book1, borrower1);
        //Then the library's stock is 0
        assertEquals(0, library.stockCount());
        //AND the borrower's borrowed List is 1
        assertEquals(1, borrower1.borrowedListSize());
    }

    @Test
    public void canCheckOutBook__bookDoesNotExist(){
        //Given there is a library
        assertNotNull(library);
        //AND there is a book
        assertNotNull(book1);
        //AND there is a borrower
        assertNotNull(borrower1);
        //AND a book is in the library stock
        library.addBook(book1);
        //When the library tries to checkout a non-existent book to a borrower
        library.checkOut(book2, borrower1);
        //Then the library's stock is 1
        assertEquals(1, library.stockCount());
        //AND the borrower's borrowed List is 0
        assertEquals(0, borrower1.borrowedListSize());
    }
}
