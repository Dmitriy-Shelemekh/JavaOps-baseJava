package storage;

import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private int resumeCount = 4;
    private Resume testResume = new Resume("uuid25");
    private Storage storage;

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void beforeTest() {
        storage.clear();
    }

    @Test
    public void testGetSize() {
        fillStorageTestData(storage, resumeCount);
        Assert.assertTrue("Ошибка при получении размера массива",
                storage.getSize() == resumeCount);
    }

    @Test
    public void testGetAll() {
        fillStorageTestData(storage, resumeCount);
        Assert.assertTrue("Ошибка: Массив пуст.",
                storage.getAll().length == resumeCount);
    }

    @Test
    public void testUpdate() {
        storage.save(testResume);
        storage.update(testResume);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateError() {
        storage.update(testResume);
    }

    @Test
    public void testSave() {
        storage.save(testResume);
        Assert.assertTrue("Ошибка при сохраниении массива.",
                storage.getIndex(testResume.getUuid()) >= 0);
    }

    @Test(expected = RuntimeException.class)
    public void testStorageOverflow() {
        try {
            fillStorageTestData(storage, 10000);
        } catch (Exception e) {
            Assert.fail("Ошибка: " + e);
        }

        storage.save(new Resume("Overflowed"));
    }

    @Test
    public void testClear() {
        fillStorageTestData(storage, resumeCount);
        Assert.assertFalse("Ошибка: Массив не должен быть пустым.",
                storage.getSize() == 0);

        storage.clear();
        Assert.assertTrue("Ошибка при очистке массива.",
                storage.getSize() == 0);
    }

    @Test
    public void testDelete() {
        storage.save(testResume);
        storage.delete(testResume.getUuid());

        Assert.assertTrue("Ошибка при удалении объекта.",
                storage.getIndex(testResume.getUuid()) < 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteError() {
        storage.delete(testResume.getUuid());
    }

    @Test
    public void testGet() {
        storage.save(testResume);
        Assert.assertEquals("Ошибка при получении объекта из массива.",
                testResume,
                storage.get(testResume.getUuid()));
    }

    @Test
    public void testGetNull() {
        Assert.assertTrue("Ошибка при получении объекта из массива.",
                storage.get(testResume.getUuid()) == null);
    }


    private void fillStorageTestData(Storage storage, int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }

        while (count > 0) {
            storage.save(new Resume("uuid" + count));
            count--;
        }
    }
}