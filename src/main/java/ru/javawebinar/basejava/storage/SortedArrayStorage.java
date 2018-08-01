package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

//    private static class ResumeComparator implements Comparator<Resume> {
//        @Override
//        public int compare(Resume o1, Resume o2) {
//            return o1.getUuid().compareTo(o2.getUuid());
//        }
//    }
//    private static final ResumeComparator RESUME_COMPARATOR = new ResumeComparator();

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    /**
     * If the binary search method returns a negative value that is equivalent to (- <insertion point> - 1),
     * where insertion point is defined as the index at which the search key would be inserted into the array
     *
     * @param uuid
     * @return position of searched element
     */
    @Override
    protected Integer getSearchKey(String uuid) {
        return Arrays.binarySearch(resumeArrayStorage, 0, size, new Resume(uuid), RESUME_COMPARATOR);
    }

    @Override
    protected void insertElement(int index, Resume resume) {
        int position = Math.abs(index) - 1;
        System.arraycopy(resumeArrayStorage, position, resumeArrayStorage, position + 1, size - position);
        resumeArrayStorage[position] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numMoved = size - index;
        if (numMoved > 0) {
            System.arraycopy(resumeArrayStorage, index + 1, resumeArrayStorage, index, numMoved);
        }
    }
}
