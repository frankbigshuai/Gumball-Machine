package edu.iu.habahram.GumballMachine.model;

public class SoldOutState implements IState{
    IGumballMachine gumballMachine;
    public SoldOutState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public TransitionResult insertQuarter() {
        gumballMachine.changeTheStateTo(GumballMachineState.HAS_QUARTER);
        String message = "Soldout";
        boolean succeeded = false;
        int count = gumballMachine.getCount();
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), count);
    }
    @Override
    public TransitionResult ejectQuarter() {
        String message = "Ejecting Quarter";
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult turnCrank() {
        String message = "Soldout";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult dispense() {
        String message = "Soldout";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());

    }
    @Override
    public String getTheName() {
        return GumballMachineState.NO_QUARTER.name();
    }
    private IState currentState;
    private int gumballCount;

    // Other methods...

    @Override
    public void refill(int count) {
        this.gumballCount += count;
        System.out.println("Added " + count + " gumballs to the machine.");
        if (currentState instanceof SoldOutState && gumballCount > 0) {
            changeTheStateTo(GumballMachineState.NO_QUARTER);
        }
    }

}
