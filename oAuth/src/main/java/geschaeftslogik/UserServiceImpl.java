package geschaeftslogik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import datenzugriffsschicht.User;
import datenzugriffsschicht.UserGroup;
import geschaeftslogik.UserService;
import datenzugriffsschicht.Token;

public class UserServiceImpl implements UserService{
    ArrayList<User> users;
    HashMap<Token,User> tokenUserMap;
    int nextToken;
    public UserServiceImpl(){
        tokenUserMap = new HashMap<>();
        users = new ArrayList<>();
        users.add(new User("admin","admin",1,true,"a@b.com",UserGroup.ADMIN));
        users.add(new User("sepp","sepp",2,true,"a@b.com",UserGroup.NORMAL));
        users.add(new User("hans","hans",3,true,"a@b.com",UserGroup.ADMIN));
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
    public User authenticateUser(String user, String pwd){
        for(User u:users){
            if(u.getName().equals(user) && u.getPassword().equals(pwd)){
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
    
    public Token createToken(String user, String pwd){
        User u = authenticateUser(user, pwd);
        if(u == null){
            return null;
        }
        if(tokenUserMap.containsValue(u)){
            for(Entry<Token, User> e:tokenUserMap.entrySet()){
                if(e.getValue().equals(u)){
                    return e.getKey();
                }
            }
            return null;
        }else{
            Token help = new Token(nextToken);
            nextToken++;
            tokenUserMap.put(help, u);
            return help;
        }
    }
    
    public User validateToken(Token token){
        //TODO: Prüfung auf gültigkeit (nicht abgelaufen)
        if(tokenUserMap.containsKey(token)){
            return tokenUserMap.get(token);
        }else{
            return null;
        }
    }

}
