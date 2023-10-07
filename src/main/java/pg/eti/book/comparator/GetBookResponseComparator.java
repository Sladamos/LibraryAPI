package pg.eti.book.comparator;

import pg.eti.book.dto.GetBookResponse;

import java.util.Comparator;

public class GetBookResponseComparator implements Comparator<GetBookResponse> {
    @Override
    public int compare(GetBookResponse o1, GetBookResponse o2) {
        int authorComparisonResult = o1.getAuthor().compareTo(o2.getAuthor());
        if(authorComparisonResult != 0) {
            return authorComparisonResult;
        } else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
