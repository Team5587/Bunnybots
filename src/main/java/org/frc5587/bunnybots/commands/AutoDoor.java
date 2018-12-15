package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDoor extends Command {
    private Timer timer = new Timer();

    public AutoDoor() {
        requires(Robot.door);
    }

    @Override
    protected void initialize() {
        timer.start();
        Robot.door.doorOpen();
    }

    @Override
    protected boolean isFinished() {
        return timer.hasPeriodPassed(3);
    }

    @Override
    protected void end() {
        Robot.door.doorClose();
        timer.stop();
    }
}