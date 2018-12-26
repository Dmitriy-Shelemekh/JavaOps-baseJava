package exception;

public class StorageNotExistException extends StorageException {
    public StorageNotExistException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}