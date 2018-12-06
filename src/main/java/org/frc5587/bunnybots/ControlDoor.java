package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.command.Command;

public class ControlDoor extends Command {
    private boolean open = false;

    public ControlDoor() {

    }

    @Override
    protected void execute() {

        if (OI.controller.getAButtonPressed() && open) {
            Robot.door.doorClose();
        } else if (OI.controller.getAButtonPressed() && !open) {
            Robot.door.doorOpen();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}