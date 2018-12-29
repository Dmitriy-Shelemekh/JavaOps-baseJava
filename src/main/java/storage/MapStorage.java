package storage;

import model.Resume;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getElementSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove(searchKey);

        //TODO Переделать этот медот по нормальному
        //Resume toDelete = map.get(searchKey);
        //Resume last = map.get(map.size() - 1);
        //map.get(searchKey).setUuid(last.getUuid());
        //map.remove(map.size() - 1);
        //Iterator itr = map.entrySet().iterator();
        //while(itr.hasNext()) {
        //    map.put("newKey", map.remove("oldKey"));
        //}
        //if ((Integer) searchKey < map.size() - 1) {
        //    map.put("newKey", map.remove("oldKey"));
        //}
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAllResumes() {
        Collection<Resume> values = map.values();
        return values.toArray(new Resume[values.size()]);
    }

    @Override
    public int getSize() {
        return map.size();
    }
}