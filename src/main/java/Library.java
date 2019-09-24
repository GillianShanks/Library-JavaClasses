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
}
