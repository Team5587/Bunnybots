package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.*;

import edu.wpi.first.wpilibj.command.Command;


public class ControlElevator extends Command {
    Elevator elevator;

    public ControlElevator() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        if (OI.controller.getBButton()) {
            Robot.elevator.elevatorUp();
        }

        else if (OI.controller.getAButton()) {
            Robot.elevator.elevatorDown();
        }
    }
}