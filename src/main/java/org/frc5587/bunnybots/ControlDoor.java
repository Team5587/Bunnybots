package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.command.Command;

public class ControlDoor extends Command {
    private boolean open = false;

    public ControlDoor() {
        requires(Robot.door);
    }

    @Override
    public synchronized void start() {
        Robot.door.doorClose();
    }

    @Override
    protected void execute() {
        if (OI.controller.getAButtonPressed() && open) {
            Robot.door.doorClose();
            open = false;
        } else if (OI.controller.getAButtonPressed() && !open) {
            Robot.door.doorOpen();
            open = true;
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}