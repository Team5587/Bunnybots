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
       if (OI.joystick.getX() < 0.1 && OI.joystick.getX() > -0.1) {
           Robot.driveTrain.driveTrainMove(OI.joystick.getY());
       }
       else if (OI.joystick.getY() < 0.1 && OI.joystick.getY() > -0.1) {
           Robot.driveTrain.driveTrainSpin(OI.joystick.getX());
       }
       else if (OI.joystick.getX() > 0.0) {
           Robot.driveTrain.driveTrainSpin(OI.joystick.getX() * 0.8);
       }
       else {
           Robot.driveTrain.driveTrainSpinAndMove((OI.joystick.getY() - OI.joystick.getX()), (OI.joystick.getY() + OI.joystick.getX()));
       }
    }
}