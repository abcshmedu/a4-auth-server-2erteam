package datenzugriffsschicht;

import java.util.Date;

public class Token {
    // https://github.com/auth0/java-jwt
    String token = "0";
    Date ablaufdatum;
    public Token(){
        generateToken();
    }
    public Token(int tokenNumber){
        this.token = String.valueOf(tokenNumber);
        generateToken();
    }
    public void generateToken(){
        ablaufdatum = new Date(2020,1,12);
    }
}
