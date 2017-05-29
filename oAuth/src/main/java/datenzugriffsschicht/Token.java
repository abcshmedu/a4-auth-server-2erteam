package datenzugriffsschicht;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Represents a token.
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
public class Token {
    // https://github.com/auth0/java-jwt
    private String token = "0";
    private Date date;
    
    /**
     * Constructs the first token.
     */
    public Token() {
        generateToken();
    }
    
    /**
     * Construcs all other tokens.
     * @param tokenNumber number of the token
     */
    public Token(int tokenNumber) {
        this.token = String.valueOf(tokenNumber);
        generateToken();
    }
    
    /**
     * Generates a token.
     */
    public void generateToken() {
    	//CHECKSTYLE:OFF
        date = new GregorianCalendar(2020, Calendar.DECEMBER, 1).getTime();
        //CHECKSTYLE:ON
    }
    
    /**
     * Returns the token.
     * @return token
     */
    public String getToken() {
        return token;
    }
    
    /**
     * Returns the date.
     * @return date
     */
    public Date getDate() {
        return date;
    }
}
