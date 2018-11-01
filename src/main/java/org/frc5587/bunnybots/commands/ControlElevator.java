package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.*;

import edu.wpi.first.wpilibj.command.Command;


public class ControlElevator extends Command {

    public ControlElevator() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        if (OI.controller.getBButtonPressed()) {
            Robot.elevator.elevatorUp();
        }

        else if (OI.controller.getAButtonPressed()) {
            Robot.elevator.elevatorDown();
            System.out.println("else if");
        }
    }
}