package geschaeftslogik;

import java.util.ArrayList;
import java.util.Date;
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
    public User updateUser(int id, User u) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getUser(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
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
        User[] array = new User[users.size()];
        users.toArray(array);
        return array;
    }
    
    @Override
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
    
    @Override
    public User validateToken(String token) {      
        Date now = new Date();
        for (Entry<Token, User> e: tokenUserMap.entrySet()) {
            if (e.getKey().getToken().equals(token) && now.before(e.getKey().getDate())) {
                //todo: Prüfung auf gültigkeit (nicht abgelaufen)
                return tokenUserMap.get(e.getKey());
            }
        }
        return null;       
//        if (tokenUserMap.containsKey(token)) {
//            return tokenUserMap.get(token);
//        } else {
//            return null;
//        }
    }

}
