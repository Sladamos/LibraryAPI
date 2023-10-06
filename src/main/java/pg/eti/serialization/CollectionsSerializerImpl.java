package pg.eti.serialization;

import java.io.*;
import java.util.Collection;

public class CollectionsSerializerImpl implements CollectionsSerializer {
	@Override
	public <T extends Serializable> void saveToOutputStream(OutputStream os, Collection<T> collection) {
		try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
			oos.writeObject(collection);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public <T extends Serializable> Collection<T> loadFromInputStream(InputStream is) {
		try (ObjectInputStream ois = new ObjectInputStream(is)) {
			return (Collection<T>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
