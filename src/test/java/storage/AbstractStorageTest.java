package storage;

import exception.StorageExistException;
import exception.StorageNotExistException;
import model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String resume_1Uuid = "uuid1";
    private static final String resume_2Uuid = "uuid2";
    private static final String resume_3Uuid = "uuid3";
    private static final String resume_4Uuid = "uuid4";

    private static final Resume RESUME_1 = new Resume("uuid1");
    private static final Resume RESUME_2 = new Resume("uuid2");
    private static final Resume RESUME_3 = new Resume("uuid3");
    private static final Resume RESUME_4 = new Resume("uuid4");

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

        assertEquals("Ошибка при проверке массива", 3, storage.getSize());
        assertTrue("Ошибка при проверке елемента массива", isResumeExist(RESUME_1, resumes));
        assertTrue("Ошибка при проверке елемента массива", isResumeExist(RESUME_2, resumes));
        assertTrue("Ошибка при проверке елемента массива", isResumeExist(RESUME_3, resumes));
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
        int size = storage.getSize();
        storage.delete(resume_1Uuid);
        assertSize(size - 1);
        storage.getResume(resume_1Uuid);
    }

    @Test(expected = StorageNotExistException.class)
    public void testDeleteError() {
        storage.delete(resume_4Uuid);
    }

    @Test
    public void testGet() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = StorageNotExistException.class)
    public void testGetNotExist() {
        storage.getResume(resume_4Uuid);
    }

    private void assertGet(Resume resume) {
        assertEquals("Ошибка при получении объекта из массива",
                resume, storage.getResume(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals("Ошибка при проверке колличества элементов",
                size, storage.getSize());
    }

    private boolean isResumeExist(Resume searchResume, Resume[] resumes) {
        for (Resume resume : resumes) {
            if (resume.equals(searchResume)) {
                return true;
            }
        }

        return false;
    }
}