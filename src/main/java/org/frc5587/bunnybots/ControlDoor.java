package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.command.Command;

public class ControlDoor extends Command {

    public ControlDoor() {

    }

    @Override
    protected void execute() {

        /*
         * won't this actually be controlled based on the input from the system that
         * determines the colour of the balls in the intake?
         */
        if (OI.controller.getAButtonPressed()) {
            Robot.door.doorClose();
        } else if (OI.controller.getYButtonPressed()) {
            Robot.door.doorOpen();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}