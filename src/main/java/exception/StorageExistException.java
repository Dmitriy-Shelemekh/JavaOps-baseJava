package exception;

public class StorageExistException extends StorageException {
    public StorageExistException(String uuid) {
        super("Resume " + uuid + " already exist", uuid);
    }
}