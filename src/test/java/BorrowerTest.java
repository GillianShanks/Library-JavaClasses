import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BorrowerTest {

    Borrower borrower1;
    Book book1;

    @Before
    public void before(){
        borrower1 = new Borrower();
        book1 = new Book("How to Java", "Ally M", "Computing");

    }

    @Test
    public void borrowedListStartsEmpty(){
        //Given there is a borrower
        assertNotNull(borrower1);
        //When
        //Then their borrowed list has size 0
        assertEquals(0, borrower1.borrowedListSize());
    }

    @Test
    public void canAddBookToBorrower(){
        //Given there is a borrower
        assertNotNull(borrower1);
        //AND there is a book
        assertNotNull(book1);
        //When I add a book to the borrower's list
        borrower1.addBook(book1);
        //Then the borrower's list is size 1
        assertEquals(1, borrower1.borrowedListSize());
    }
}
