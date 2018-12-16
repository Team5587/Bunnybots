package org.frc5587.bunnybots.commands.autonomous;

import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class StopIntake extends InstantCommand {
    public StopIntake() {
        
    }

    @Override
    protected void execute() {
        Robot.intake.intakeOff();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}