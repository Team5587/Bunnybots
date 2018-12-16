package org.frc5587.bunnybots.commands.autonomous;

import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class RunIntake extends InstantCommand {
    public RunIntake() {
        
    }

    @Override
    protected void execute() {
        Robot.intake.intakeOn();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}