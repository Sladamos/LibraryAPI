package pg.eti.book.comparator;

import pg.eti.book.entity.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        int authorComparisonResult = o1.getAuthor().compareTo(o2.getAuthor());
        if(authorComparisonResult != 0) {
            return authorComparisonResult;
        } else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
