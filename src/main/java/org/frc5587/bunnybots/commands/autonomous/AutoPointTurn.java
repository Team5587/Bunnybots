package org.frc5587.bunnybots.commands.autonomous;

import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoPointTurn extends Command {
    private Timer timer = new Timer();

    public AutoPointTurn() {
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        timer.start();
        Robot.driveTrain.driveTrainSpin(0.5);
    }

    @Override
    protected boolean isFinished() {
        return timer.hasPeriodPassed(.5);
    }

    @Override
    protected void end() {
        Robot.driveTrain.driveTrainSpin(0);
        timer.stop();
    }
}