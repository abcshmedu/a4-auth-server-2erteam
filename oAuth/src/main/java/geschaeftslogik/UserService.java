package geschaeftslogik;

import datenzugriffsschicht.Token;
import datenzugriffsschicht.User;

/**
 * 
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
public interface UserService {

    /**
     * Updates an user.
     * @param u user
     * @return the updated user
     */
    User updateUser(User u);
    
    /**
     * Returns one specific user.
     * @param id from the user
     * @return the user
     */
    User getUser(int id);
    
    /**
     * Lists all user.
     * @return an array with all users
     */
    User[] getUsers();
    
    /**
     * Authenticates an user.
     * @param user to authenticate
     * @param pwd from the user
     * @return the authenticated user
     */
    User authenticateUser(String user, String pwd);
    
    /**
     * Creates a token.
     * @param user who needs a token
     * @param pwd from the user
     * @return a new token
     */
    Token createToken(String user, String pwd);
}
