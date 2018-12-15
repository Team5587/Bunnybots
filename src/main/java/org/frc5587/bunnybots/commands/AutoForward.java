package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoForward extends Command {
    private Timer timer = new Timer();

    public AutoForward() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        timer.start();
        Robot.driveTrain.driveTrainMove(.5);
    }

    @Override
    protected boolean isFinished() {
        return timer.hasPeriodPassed(2);
    }

    @Override
    protected void end() {
        Robot.driveTrain.driveTrainMove(0);
        timer.stop();
    }
}