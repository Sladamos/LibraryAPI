package pg.eti.book.comparator;

import pg.eti.book.entity.PublishingHouse;

import java.util.Comparator;

public class PublishingHouseComparator implements Comparator<PublishingHouse> {
    @Override
    public int compare(PublishingHouse o1, PublishingHouse o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
