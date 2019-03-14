package blobs_previous_exam.interfaces;

import blobs_previous_exam.models.Blob;

import java.util.Collection;

public interface Repository<T> {

    void add(T t);

    T getByName(String name);

    Collection<T> findAll();
}
