package geschaeftslogik;

import java.util.ArrayList;

import datenzugriffsschicht.User;
import datenzugriffsschicht.UserGroup;
import geschaeftslogik.UserService;

public class UserServiceImpl implements UserService{
    ArrayList<User> users;
    public UserServiceImpl(){
        users.add(new User("admin","admin",1,true,"a@b.com",UserGroup.ADMIN));
        users.add(new User("sepp","sepp",2,true,"a@b.com",UserGroup.NORMAL));
        users.add(new User("hans","hans",3,true,"a@b.com",UserGroup.ADMIN));
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

    @Override
    public User[] getUsers() {
        // TODO Auto-generated method stub
        return null;
    }

}
