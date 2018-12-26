package exception;

public class StorageOverflowException extends StorageException {
    public StorageOverflowException(String uuid) {
        super("Storage overflow ", uuid);
    }
}