package pg.eti.book.comparator;

import pg.eti.book.entity.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int titleComparisonResult = o1.getTitle().compareTo(o2.getTitle());
        if(titleComparisonResult != 0) {
            return titleComparisonResult;
        } else {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }
}
