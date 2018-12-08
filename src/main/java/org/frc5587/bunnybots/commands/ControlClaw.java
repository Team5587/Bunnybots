package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.OI;
import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlClaw extends Command {

    public ControlClaw() {

    }

    @Override
    protected void execute() {

        if (OI.controller.getBButtonPressed()) {
            Robot.claw.clawClose();
        } else if (OI.controller.getXButtonPressed()) {
            Robot.claw.clawOpen();
        }

        if(Math.abs(OI.controller.getY(Hand.kLeft)) > .05) {
            Robot.claw.clawArmMove(OI.controller.getY(Hand.kLeft));
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}