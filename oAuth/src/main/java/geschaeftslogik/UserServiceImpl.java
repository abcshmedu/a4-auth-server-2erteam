package geschaeftslogik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import datenzugriffsschicht.User;
import datenzugriffsschicht.UserGroup;
import datenzugriffsschicht.Token;

/**
 * Implementation UserService.
 * @author Altvatter Robert, Großbeck Thomas
 *
 */
public class UserServiceImpl implements UserService {
    private ArrayList<User> users;
    private HashMap<Token, User> tokenUserMap;
    private int nextToken;
    
    /**
     * Constructs an user service with some default users.
     */
    public UserServiceImpl() {
        tokenUserMap = new HashMap<>();
        users = new ArrayList<>();
        users.add(new User("admin", "admin", 1, true, "a@b.com", UserGroup.ADMIN));
        users.add(new User("sepp", "sepp", 2, true, "a@b.com", UserGroup.NORMAL));
        //CHECKSTYLE:OFF
        users.add(new User("hans", "hans", 3, true, "a@b.com", UserGroup.ADMIN));
        //CHECKSTYLE:ON
        nextToken = 0;
    }

    @Override
    public User updateUser(User u) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(int id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * Authenticates an user.
     * @param user user to authenticate
     * @param pwd from the user
     * @return the user if the token is validated else returns null.
     */
    public User authenticateUser(String user, String pwd) {
        for (User u:users) {
            if (u.getName().equals(user) && u.getPassword().equals(pwd)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User[] getUsers() {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * Creates a new token.
     * @param user user who needs a token
     * @param pwd from the user
     * @return Token new token
     */
    public Token createToken(String user, String pwd) {
        User u = authenticateUser(user, pwd);
        if (u == null) {
            return null;
        }
        if (tokenUserMap.containsValue(u)) {
            for (Entry<Token, User> e:tokenUserMap.entrySet()) {
                if (e.getValue().equals(u)) {
                    return e.getKey();
                }
            }
            return null;
        } else {
            Token help = new Token(nextToken);
            nextToken++;
            tokenUserMap.put(help, u);
            return help;
        }
    }
    
    /**
     * Checks if a token is validated.
     * @param token to check
     * @return the user who owns the token else null
     */
    public User validateToken(Token token) {
        //todo: Prüfung auf gültigkeit (nicht abgelaufen)
        if (tokenUserMap.containsKey(token)) {
            return tokenUserMap.get(token);
        } else {
            return null;
        }
    }

}
