package storage;

import exception.StorageExistException;
import exception.StorageNotExistException;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractStorageTest {

    private static final Resume RESUME_1 = new Resume("uuid1");
    private static final Resume RESUME_2 = new Resume("uuid2");
    private static final Resume RESUME_3 = new Resume("uuid3");
    private static final Resume RESUME_4 = new Resume("uuid4");
    protected Storage storage;

    AbstractStorageTest(Storage storage) {
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
        Resume[] resumes = storage.getAllResumes();

        Assert.assertEquals("Ошибка при проверке массива", 3, storage.getSize());
        Assert.assertTrue("Ошибка при проверке елемента массива", isResumeExist(RESUME_1, resumes));
        Assert.assertTrue("Ошибка при проверке елемента массива", isResumeExist(RESUME_2, resumes));
        Assert.assertTrue("Ошибка при проверке елемента массива", isResumeExist(RESUME_3, resumes));
    }

    @Test
    public void testUpdate() {
        storage.update(RESUME_1);
        assertGet(RESUME_1);
    }

    @Test(expected = StorageNotExistException.class)
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

    @Test(expected = StorageExistException.class)
    public void testSaveAlreadyExist() {
        storage.save(RESUME_1);
    }

    @Test
    public void testClear() {
        storage.clear();
        assertSize(0);
    }

    @Test(expected = StorageNotExistException.class)
    public void testDelete() {
        storage.delete(RESUME_1.getUuid());
        assertSize(2);
        storage.getResume(RESUME_1.getUuid());
    }

    @Test(expected = StorageNotExistException.class)
    public void testDeleteError() {
        storage.delete(RESUME_4.getUuid());
    }

    @Test
    public void testGet() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = StorageNotExistException.class)
    public void testGetNotExist() {
        storage.getResume(RESUME_4.getUuid());
    }

    private void assertGet(Resume r) {
        Assert.assertEquals("Ошибка при получении объекта из массива",
                r, storage.getResume(r.getUuid()));
    }

    private void assertSize(int size) {
        Assert.assertEquals("Ошибка при проверке колличества элементов",
                size, storage.getSize());
    }

    private boolean isResumeExist(Resume resume, Resume[] resumes) {
        for (Resume r : resumes) {
            if (r.equals(resume)) {
                return true;
            }
        }

        return false;
    }
}