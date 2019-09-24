import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookStock;
    private int capacity;

    public Library(int capacity){
        this.bookStock = new ArrayList<Book>();
        this.capacity = capacity;
    }

    public int stockCount() {
        return this.bookStock.size();
    }

    public void addBook(Book book) {
        if (this.hasSpace()) {
            this.bookStock.add(book);
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasSpace() {
        return this.stockCount() < this.capacity;
    }

//    public void checkOut(Book book1, Borrower borrower1) {
//
//    }



    public Book removeBook(Book selectedBook) {

        //find Book index
        int index = this.bookStock.indexOf(selectedBook);
        //remove book by index
        if (index>=0) {
            return this.bookStock.remove(index);
        }
        return null;
    }
}
