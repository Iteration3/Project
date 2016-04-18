package AI;

import models.Stat.Stat;

/**
 * Created by denzel on 4/16/16.
 */
public class FSM {

    //An array of states????
    public FSMState[] states;

    //Every FSM will have a set of states that it will transition from??
    public FSM(FSMState[] states){
        this.states = states;
    }

}
