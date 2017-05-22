package geschaeftslogik;

import datenzugriffsschicht.Token;
import datenzugriffsschicht.User;

public interface UserService {
    public User updateUser(User u);
    public User getUser(int id);
    public User[] getUsers();
    public User authenticateUser(String user, String pwd);
    public Token createToken(String user, String pwd);
}
