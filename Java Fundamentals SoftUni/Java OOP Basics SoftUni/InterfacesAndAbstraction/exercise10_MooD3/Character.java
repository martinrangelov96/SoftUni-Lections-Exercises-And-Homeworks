package exercise10_MooD3;

public interface Character<T> {

    String getUsername();
    String getHashedPassword();
    Integer getLevel();
    T getSpecialPoints();
    String hashPass();
    void setHashedPassword(T hashedPassword);

}
