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
    public synchronized void start() {
        timer.start();
        Robot.driveTrain.driveTrainMove(1);
    }

    @Override
    protected boolean isFinished() {
        if (timer.hasPeriodPassed(2.0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void end() {
        timer.stop();
        Robot.driveTrain.driveTrainMove(0);
    }
}