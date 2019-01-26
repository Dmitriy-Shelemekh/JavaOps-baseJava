package storage;

import exception.StorageExistException;
import exception.StorageNotExistException;
import model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1 = new Resume(UUID_1, "Resume-1");
    private static final Resume RESUME_2 = new Resume(UUID_2, "Resume-2");
    private static final Resume RESUME_3 = new Resume(UUID_3, "Resume-3");
    private static final Resume RESUME_4 = new Resume(UUID_4, "Resume-4");

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
        List<Resume> list = storage.getAllResumes();
        List<Resume> expectedList = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);

        assertEquals("Ошибка при проверке размера массива",
                3, list.size());
        assertEquals("Ошибка при проверке елементов массива",
                list, expectedList);
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
        storage.delete(UUID_1);
        assertSize(size - 1);
        storage.getResume(UUID_1);
    }

    @Test()
    public void testSuccessDelete() {
        int size = storage.getSize();
        storage.delete(UUID_1);
        assertSize(size - 1);
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
        storage.getResume(UUID_4);
    }

    private void assertGet(Resume resume) {
        assertEquals("Ошибка при получении объекта из массива",
                resume, storage.getResume(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals("Ошибка при проверке колличества элементов",
                size, storage.getSize());
    }
}