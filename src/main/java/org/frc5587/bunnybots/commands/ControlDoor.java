package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.OI;
import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ControlDoor extends Command {

    public ControlDoor() {
        requires(Robot.door);
    }

    @Override
    public synchronized void start() {
        Robot.door.doorClose();
    }

    @Override
    protected void execute() {
        if (OI.controller.getAButton()) {
            Robot.door.doorOpen();
        } else {
            Robot.door.doorClose();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}