package datenzugriffsschicht;

import java.util.ArrayList;

/**
 * Represents an user in the system.
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
public class User {
    private String name;
    private String password;
    private int id;
    private boolean active;
    private String email;
    private UserGroup group;
    private ArrayList<Token> myTokens;
    
    /**
     * Default constructor.
     */
    User() {
        
    }
    
    /**
     * constructs an user.
     * @param name of the user
     * @param password of the user
     * @param id of the user
     * @param active true if the user is activated
     * @param email from the user
     * @param group usergroup from the user
     */
    public User(String name, String password, int id, boolean active, String email, UserGroup group) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.active = active;
        this.email = email;
        this.group = group;
        this.myTokens = new ArrayList<Token>();
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }
    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the group
     */
    public UserGroup getGroup() {
        return group;
    }
    /**
     * @param group the group to set
     */
    public void setGroup(UserGroup group) {
        this.group = group;
    }
        
}
