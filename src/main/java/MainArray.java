import model.Resume;
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

            String param_1 = null;
            String param_2 = null;

            if (params.length == 2) {
                param_2 = params[1].intern();
            }

            if (params.length == 3) {
                param_1 = params[1].intern();
                param_2 = params[2].intern();
            }

            switch (params[0]) {
                case "list":
                    printAll();
                    break;
                case "size":
                    System.out.println(ARRAY_STORAGE.getSize());
                    break;
                case "save":
                    if (param_1 == null) {
                        resume = new Resume(param_2);
                    } else {
                        resume = new Resume(param_1, param_2);
                    }
                    ARRAY_STORAGE.save(resume);
                    printAll();
                    break;
                case "delete":
                    ARRAY_STORAGE.delete(param_2);
                    printAll();
                    break;
                case "get":
                    System.out.println(ARRAY_STORAGE.getResume(param_2));
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