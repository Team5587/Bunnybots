package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.*;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlClimber extends Command{

    public ControlClimber() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        if(OI.controller.getStickButton(Hand.kRight)) {
            Robot.climber.climberUp();
        }
    }
}