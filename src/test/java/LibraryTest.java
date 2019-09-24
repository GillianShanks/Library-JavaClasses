import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LibraryTest {

    Library library;
    Book book1;

    @Before
    public void before(){
        library = new Library();
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
}
