package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.*;

public class ControlDriveTrain extends Command {
    DriveTrain driveTrain;

    public ControlDriveTrain() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.DriveTrain.driveTrainForward(joystick.getY());

        Robot.DriveTrain.driveTrainBackward(joystick.getY());

    }
}