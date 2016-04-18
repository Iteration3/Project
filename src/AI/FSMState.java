package AI;

/**
 * Created by denzel on 4/17/16.
 */
public class FSMState {

    //Enum of states
    public enum States{
        WANDER,
        AWARE,
        ATTACK
    }

    private States state;

    //Constructor of the state
    public FSMState(States state){
        this.state = state;
    }


    //getters
    public States getState(){
        return state;
    }

    //TODO: might not need
    //setters
    public void setState(States state){
        this.state = state;
    }
}
