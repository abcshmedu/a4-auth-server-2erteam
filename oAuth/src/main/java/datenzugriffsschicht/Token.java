package datenzugriffsschicht;

import java.util.Date;

/**
 * Represents a token.
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
public class Token {
    // https://github.com/auth0/java-jwt
    private String token = "0";
    private Date ablaufdatum;
    
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
        ablaufdatum = new Date(2020, 1, 12);
        //CHECKSTYLE:ON
    }
}
