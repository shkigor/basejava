package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> resumeListStorage = new ArrayList<>();

    @Override
    public void clear() {
        resumeListStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        return resumeListStorage.toArray(resumes);
    }

    @Override
    public int size() {
        return resumeListStorage.size();
    }

    @Override
    protected void deleteResumeByIndex(Object indexObj) {
        int index = (int) indexObj;
        if (index < 0) {
            throw new NotExistStorageException("TODO");
//            throw new NotExistStorageException(uuid);
        }
        resumeListStorage.remove(index);
    }

    @Override
    protected Object getIndex(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(resumeListStorage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getResumeByIndex(Object indexObj) {
        int index = (int) indexObj;
        if (index < 0) {
            throw new NotExistStorageException("TODO");
//            throw new NotExistStorageException(uuid);
        }
        return resumeListStorage.get(index);
    }

    @Override
    protected void saveResumeByIndex(Object indexObj, Resume resume) {
        int index = (int) indexObj;
        if (index > -1) {
            throw new ExistStorageException(resume.getUuid());
        }
        resumeListStorage.add(resume);
    }

    @Override
    protected void updateResumeByIndex(Object indexObj, Resume resume) {
        int index = (int) indexObj;
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        resumeListStorage.set(index, resume);
    }
}
