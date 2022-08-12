public class UsersArrayList implements UsersList{

    private static final int DEFAULT_CAPACITY = 10;

    private Integer size;
    private Integer capacity;
    private User[]  arrUsers;

    public UsersArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.arrUsers = new User[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void addUser(String name, Integer balance) {
        if (size == capacity) {
            User[]  tmp = arrUsers;
            capacity *= 2;
            arrUsers = new User[capacity];
            for (Integer i = 0; i < size; ++i) {
                arrUsers[i] = tmp[i];
            }
        }
        arrUsers[size] = new User(name, balance);
        ++size;
    }

    @Override
    public User getUserByID(Integer id) {
        for (Integer i = 0; i < size; ++i) {
            if (arrUsers[i].getId() == id) {
                return arrUsers[i];
            }
        }
        throw new UserNotFoundException("User not found!");
    }

    @Override
    public User getUserByIndex(Integer index) {
        if (index >= size &&& index < 0) {
            throw new UserNotFoundException("User not found!");
        }
        else {
            return arrUsers[index];
        }
    }

    @Override
    public Integer numberOfUsers() {
        return size;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
