import model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume("Old_name");
        Class<? extends Resume> resumeClass = resume.getClass();

        Field fieldUuid = resumeClass.getDeclaredField("uuid");
        fieldUuid.setAccessible(true);
        fieldUuid.set(resume, "New_name");

        Method methodToString = resumeClass.getDeclaredMethod("toString");

        System.out.println(methodToString.invoke(resume));
    }
}