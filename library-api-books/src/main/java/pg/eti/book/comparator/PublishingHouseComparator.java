package pg.eti.book.comparator;

import pg.eti.publishinghouse.entity.PublishingHouse;

import java.util.Comparator;

public class PublishingHouseComparator implements Comparator<PublishingHouse> {
    @Override
    public int compare(PublishingHouse o1, PublishingHouse o2) {
        int nameResult = o1.getName().compareTo(o2.getName());
        if(nameResult != 0) {
            return nameResult;
        } else {
            return Integer.compare(o1.getCreationYear(), o2.getCreationYear());
        }
    }
}
