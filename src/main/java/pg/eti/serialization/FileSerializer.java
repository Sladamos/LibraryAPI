package pg.eti.serialization;

import java.io.*;
import java.util.Collection;

public class FileSerializer<T extends Serializable> {
	public void serializeToFile(Collection<T> seriallizableCollection, String fileName) {
		try (FileOutputStream os = new FileOutputStream(fileName);
		     ObjectOutputStream oos = new ObjectOutputStream(os)) {
			oos.writeObject(seriallizableCollection);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Collection<T> serializeFromFile(String fileName) {
		try (FileInputStream is = new FileInputStream(fileName);
		     ObjectInputStream ois = new ObjectInputStream(is)) {
			return (Collection<T>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
