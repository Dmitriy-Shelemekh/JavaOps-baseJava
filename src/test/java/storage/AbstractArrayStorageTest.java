package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {

    private Storage storage;
    private static final Resume RESUME_1 = new Resume("uuid1");
    private static final Resume RESUME_2 = new Resume("uuid2");
    private static final Resume RESUME_3 = new Resume("uuid3");
    private static final Resume RESUME_4 = new Resume("uuid4");

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void beforeTest() {
        storage.clear();

        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void testGetSize() {
        assertSize(3);
    }

    @Test
    public void testGetAll() {
        Resume[] resumes = storage.getAll();

        Assert.assertEquals("Ошибка при проверке массива", 3, storage.getSize());
        Assert.assertEquals("Ошибка при проверке елемента массива", RESUME_1, resumes[0]);
        Assert.assertEquals("Ошибка при проверке елемента массива", RESUME_2, resumes[1]);
        Assert.assertEquals("Ошибка при проверке елемента массива", RESUME_3, resumes[2]);
    }

    @Test
    public void testUpdate() {
        storage.update(RESUME_1);
        assertGet(RESUME_1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateError() {
        storage.update(RESUME_4);
    }

    @Test
    public void testSave() {
        int size = storage.getSize();
        storage.save(RESUME_4);
        assertSize(size + 1);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void testSaveAlreadyExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = RuntimeException.class)
    public void testStorageOverflow() {
        try {
            for (int i = storage.getSize(); i <= AbstractArrayStorage.STORAGE_LIMIT + 1; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            Assert.fail("Ошибка: " + e);
        }
        storage.save(new Resume("Overflowed"));
    }

    @Test
    public void testClear() {
        storage.clear();
        assertSize(0);
    }

    @Test(expected = NotExistStorageException.class)
    public void testDelete() {
        storage.delete(RESUME_1.getUuid());
        assertSize(2);
        storage.get(RESUME_1.getUuid());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteError() {
        storage.delete(RESUME_4.getUuid());
    }

    @Test
    public void testGet() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void testGetNotExist() {
        storage.get(RESUME_4.getUuid());
    }

    private void assertGet(Resume r) {
        Assert.assertEquals("Ошибка при получении объекта из массива",
                r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        Assert.assertEquals("Ошибка при проверке колличества элементов",
                size, storage.getSize());
    }
}