package exception;

public class OverflovStorageExeption extends StorageException {
    public OverflovStorageExeption(String uuid) {
        super("Storage overflow ", uuid);
    }
}