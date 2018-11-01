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
        if (OI.controller.getBButton()) {
            Robot.driveTrain.driveTrainForward();
        }

        else if (OI.controller.getAButton()) {
            Robot.driveTrain.driveTrainBackward();
        }
    }
}