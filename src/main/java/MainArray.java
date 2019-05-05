import model.Resume;
import org.apache.commons.lang3.StringUtils;
import storage.ArrayStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainArray {
    private final static ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume resume;

        while (true) {
            System.out.print("Введите одну из команд - (list | save (Uuid + Full_Name / Full_Name) | delete (Uuid) | get(Uuid) | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");

            if (params.length < 1 || params.length > 3) {
                System.out.println("Неверная команда.");
                continue;
            }

            String uuid = StringUtils.EMPTY;
            String fullName = StringUtils.EMPTY;

            if (params.length == 2) {
                fullName = params[1].intern();
            }

            if (params.length == 3) {
                uuid = params[1].intern();
                fullName = params[2].intern();
            }

            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.getSize());
                    break;
                case "save":
                    if (StringUtils.isEmpty(uuid)) {
                        resume = new Resume(fullName);
                    } else {
                        resume = new Resume(uuid, fullName);
                    }
                    ARRAY_STORAGE.save(resume);
                    printAll();
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(fullName);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.getResume(fullName));
                    break;
                case "clear":
                    ARRAY_STORAGE.clear();
                    printAll();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    private static void printAll() {
        Resume[] all = (Resume[]) ARRAY_STORAGE.getAllResumes().toArray();
        System.out.println("------------------------------------------------------------------------------------");

        if (all.length == 0) {
            System.out.println("Empty");
        } else {
            for (Resume resume : all) {
                    System.out.println(resume);
            }
        }

        System.out.println("------------------------------------------------------------------------------------");
    }
}