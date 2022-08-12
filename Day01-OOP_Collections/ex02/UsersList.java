public interface UsersList {

    void addUser(String name, Integer balance);

    User getUserByID(Integer id);

    User getUserByIndex(Integer index);

    Integer numberOfUsers();
}
