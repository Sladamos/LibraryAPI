package pg.eti.serialization;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collection;

public interface CollectionsSerializer {

	<T extends Serializable> void saveToOutputStream(OutputStream os, Collection<T> collection);

	<T extends Serializable> Collection<T> loadFromInputStream(InputStream is);
}
