import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookStock;

    public Library(){
        bookStock = new ArrayList<Book>();
    }

    public int stockCount() {
        return this.bookStock.size();
    }
}
