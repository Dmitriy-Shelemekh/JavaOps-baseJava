import model.Resume;
import storage.AbstractArrayStorage;
import storage.SortedArrayStorage;

public class MainTestArrayStorage {
    private static final AbstractArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume resume1 = new Resume("uuid1");
        Resume resume2 = new Resume("uuid2");
        Resume resume3 = new Resume("uuid3");
        Resume resume4 = new Resume("uuid4");
        Resume resume5 = new Resume("uuid5");

        ARRAY_STORAGE.save(resume1);
        ARRAY_STORAGE.save(resume2);
        ARRAY_STORAGE.save(resume3);
        ARRAY_STORAGE.save(resume4);
        ARRAY_STORAGE.save(resume5);

        System.out.println("Get resume1: " + ARRAY_STORAGE.getResume(resume1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.getSize());

        System.out.println("Get dummy: " + ARRAY_STORAGE.getResume("dummy"));
        printAll();

        ARRAY_STORAGE.delete(resume1.getUuid());
        printAll();

        ARRAY_STORAGE.delete(resume5.getUuid());
        printAll();

        ARRAY_STORAGE.update(resume2);
        printAll();

        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.getSize());
    }

    private static void printAll() {
        System.out.println("\nGet All");
        for (Resume resume : ARRAY_STORAGE.getAllResumes()) {
            System.out.println(resume);
        }
    }
}