package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.OI;
import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlIntake extends Command {
    private boolean on;

    public ControlIntake() {
        on = true;
    }

    @Override
    protected void execute() {
        // using getBumper as opposed to getBumperPressed for more specific control
        if (OI.controller.getBumperPressed(Hand.kRight)) {
            if (OI.controller.getStickButton(Hand.kRight)) {
                Robot.intake.intakeBack();
            } else {
                if (!on) {
                    Robot.intake.intakeOn();
                    on = true;
                } else {
                    Robot.intake.intakeOff();
                    on = false;
                }
            } 
        }
    
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}