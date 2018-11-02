package org.frc5587.bunnybots.commands;
import org.frc5587.bunnybots.*;

import edu.wpi.first.wpilibj.command.Command;

public class ControlDriveTrain extends Command {

    public ControlDriveTrain() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        Robot.driveTrain.driveTrainMove(OI.joystick.getY());
        Robot.driveTrain.driveTrainSpin(OI.joystick.getX());

    }
}