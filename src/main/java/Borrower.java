import java.util.ArrayList;

public class Borrower {

    private ArrayList<Book> borrowedList;

    public Borrower(){
        this.borrowedList = new ArrayList<Book>();
    }


    public int borrowedListSize() {
        return this.borrowedList.size();
    }

    public void addBook(Book book) {
        this.borrowedList.add(book);
    }
}
