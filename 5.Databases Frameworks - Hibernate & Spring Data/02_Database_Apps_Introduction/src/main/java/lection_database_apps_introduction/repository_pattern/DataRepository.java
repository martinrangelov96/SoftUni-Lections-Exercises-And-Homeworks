package lection_database_apps_introduction.repository_pattern;

import java.sql.SQLException;
import java.util.List;

public interface DataRepository<T> {

    List<T> getAll() throws SQLException;

    void insert(T object) throws SQLException;

}
