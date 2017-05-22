package geschaeftslogik;

import datenzugriffsschicht.User;

public interface UserService {
    public User updateUser(User u);
    public User getUser(int id);
    public User[] getUsers();
}
