package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.command.Command;

public class ControlDoor extends Command {

    public ControlDoor() {

    }

    @Override
    protected void execute() {

        if (OI.controller.getAButtonPressed()) {
            Robot.door.doorClose();
        } else if (OI.controller.getBButtonPressed()) {
            Robot.door.doorOpen();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}