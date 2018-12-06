package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlIntake extends Command {

    public ControlIntake() {

    }

    @Override
    protected void execute() {
        // using getBumper as opposed to getBumperPressed for more specific control
        if (OI.controller.getBumper(Hand.kRight)) {
            Robot.intake.intakeOn();
        } else {
            Robot.intake.intakeOff();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}