package storage;

import exception.StorageException;
import exception.StorageOverflowException;
import model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageOverflowException.class)
    public void testStorageOverflow() {
        try {
            int size = storage.getSize();
            for (int i = size; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("uuid" + (i + 1)));
            }
        } catch (StorageException e) {
            Assert.fail("Ошибка: " + e);
        }
        storage.save(new Resume("Overflowed"));
    }
}