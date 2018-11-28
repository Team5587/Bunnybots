package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.command.Command;

public class ControlClaw extends Command {

    private Claw claw = new Claw();

    public ControlClaw() {

    }

    public void FullControlClaw() {

        if (OI.controller.getBButtonPressed()) {
            claw.clawClose();
        } 
        else if (OI.controller.getXButtonPressed()) {
            claw.clawOpen();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}