package pg.eti.serialization;

import lombok.Builder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

@Builder
public class FileSerializer {

	private final CollectionsSerializer collectionsSerializer;

	public <T extends Serializable> void serializeToFile(Collection<T> seriallizableCollection, String fileName) {
		try (FileOutputStream os = new FileOutputStream(fileName)) {
			collectionsSerializer.saveToOutputStream(os, seriallizableCollection);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public <T extends Serializable> Collection<T> serializeFromFile(String fileName) {
		try (FileInputStream is = new FileInputStream(fileName)) {
			return collectionsSerializer.loadFromInputStream(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
