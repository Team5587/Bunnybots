package org.frc5587.bunnybots;

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
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}