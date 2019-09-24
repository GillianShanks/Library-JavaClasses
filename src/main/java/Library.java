import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private ArrayList<Book> bookStock;
    private int capacity;
    private HashMap<String, Integer> genreCollection;

    public Library(int capacity){
        this.bookStock = new ArrayList<Book>();
        this.capacity = capacity;
        this.genreCollection = new HashMap<String, Integer>();
    }

    public int stockCount() {
        return this.bookStock.size();
    }

    public void addBook(Book book) {
        if (this.hasSpace()) {
            this.bookStock.add(book);
            this.addToGenreCollection(book);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasSpace() {
        return this.stockCount() < this.capacity;
    }

    public void checkOut(Book book, Borrower borrower) {
        //if the borrowed book exists and is not null
        if (this.removeBook(book) != null) {
            //remove specific book from library
            Book bookToBorrow = this.removeBook(book);
            //update the genreCollection
//            TODO:
//            this.removeFromGenreCollection(book);
            //add book to borrower's list
            borrower.addBook(bookToBorrow);
        }

    }

    public Book removeBook(Book selectedBook) {

        //find Book index
        int index = this.bookStock.indexOf(selectedBook);
        //remove book by index
        if (index>=0) {
            return this.bookStock.remove(index);
        }
        return null;
    }

    public int genreCollectionCount() {
        return this.genreCollection.size();
    }

    public void addToGenreCollection(Book book) {
        //get the genre of the book
        String bookGenre = book.getGenre();
        //if the genre is present +1 to the count
        if (this.genreCollection.containsKey(bookGenre)) {
            int count = this.genreCollection.get(bookGenre);
            this.genreCollection.put(bookGenre, count+1);
        } else {
            //if the genre is not present make new key/value of 1
            this.genreCollection.put(bookGenre, 1);
        }


    }
}
