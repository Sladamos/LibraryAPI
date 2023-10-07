package pg.eti.book.comparator;

import pg.eti.book.dto.GetBookResponse;

import java.util.Comparator;

public class GetBookResponseComparator implements Comparator<GetBookResponse> {
    @Override
    public int compare(GetBookResponse o1, GetBookResponse o2) {
        int titleComparisonResult = o1.getTitle().compareTo(o2.getTitle());
        if(titleComparisonResult != 0) {
            return titleComparisonResult;
        } else {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }
}
