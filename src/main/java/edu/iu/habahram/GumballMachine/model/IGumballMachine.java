package edu.iu.habahram.GumballMachine.model;

public interface IGumballMachine {
    TransitionResult insertQuarter();
    TransitionResult ejectQuarter();
    TransitionResult turnCrank();
    TransitionResult dispense();
    void changeTheStateTo(GumballMachineState state);
    Integer getCount();
    String getTheStateName();
    void releaseBall();

    // Adds a refill method that allows adding gumballs to the machine.
    void refill(int count);
}
