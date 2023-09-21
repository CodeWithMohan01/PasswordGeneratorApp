
import java.awt.*;
import java.util.Random;
import java.util.StringJoiner;

//this class works as the backend ans will generate the password
public class PasswordGenerator {
     public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrtuvwxyz";
     public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     public static final String NUMBERS = "0123456789";
     public static  final String SPECIAL_SYMBOLS = "`-=~!@#$%^&*()_+[]{}|;':,./<>?";

    private final Random random;

    public PasswordGenerator(){
        random = new Random();
    }

    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){
        StringBuilder passwordBuilder = new StringBuilder();
        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

//        build password
        for(int i=0; i<length; i++){
//            generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

//          get the char based on the random index
            char randomChar = validCharacters.charAt(randomIndex);

//            store char into password builder
            passwordBuilder.append(randomChar);

//            do this until we have reached the length that the user has provided to us

        }
        return passwordBuilder.toString();
    }
}
