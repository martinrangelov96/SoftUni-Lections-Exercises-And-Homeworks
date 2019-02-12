package exercise10_MooD3;

public abstract class CharacterImpl<T extends Number> implements Character<T> {

    private String username;
    private String hashedPassword;
    private Integer level;

    protected CharacterImpl(String username, Integer level) {
        this.setUsername(username);
        this.setHashedPassword(hashedPassword);
        this.setLevel(level);
    }

    private void setUsername(String username) {
        if (username.length() > 10) {
            throw new IllegalArgumentException();
        }
        this.username = username;
    }

    private void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public Integer getLevel() {
        return this.level;
    }

    protected void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    //""KoHaH"" | "1519" -> Demon
    //10000.0


    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n", this.getUsername(),
                this.getHashedPassword(), this.getClass().getSimpleName());
    }
}
