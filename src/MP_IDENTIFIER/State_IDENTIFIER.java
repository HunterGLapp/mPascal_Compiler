package MP_IDENTIFIER;

import MP_IDENTIFIER.State_IDENTIFIER_TRAILING_UNDERSCORE;
import regex.State;

/**
 * Created by night on 2/4/2015.
 * Represents a valid identifier that is not and cannot be a reserved word.
 */
public class State_IDENTIFIER extends State {
    private static State state;
    private State_IDENTIFIER() {
    }
    // states are singletons
    public static State getState() {
        if(state==null) {
            return new State_IDENTIFIER();
        }
        else return state;
    }
    @Override
    public void read(char c) {
        if(!Character.isLetterOrDigit(c)) {
            if(c=='_') {
                context.changeState(State_IDENTIFIER_TRAILING_UNDERSCORE.getState());
            }
        }
    }

    @Override
    public boolean accepted() {
        return true;
    }
}