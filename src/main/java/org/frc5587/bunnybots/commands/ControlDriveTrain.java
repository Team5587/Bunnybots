package org.frc5587.bunnybots.commands;
import org.frc5587.bunnybots.*;
import org.frc5587.lib.TitanDrive;
import org.frc5587.lib.TitanDrive.DriveSignal;

import edu.wpi.first.wpilibj.command.Command;

public class ControlDriveTrain extends Command {
    private TitanDrive tightenDrive = new TitanDrive();

    public ControlDriveTrain() {
        requires(Robot.driveTrain);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {

        DriveSignal nintendoDS = tightenDrive.arcadeDrive(OI.joystick.getY(), -OI.joystick.getX());
        Robot.driveTrain.driveTrainSpinAndMove(nintendoDS.left, nintendoDS.right);

       /*if (OI.joystick.getX() < 0.2 && OI.joystick.getX() > -0.2) {
            Robot.driveTrain.driveTrainMove(OI.joystick.getY());
       } else if (OI.joystick.getY() < 0.2 && OI.joystick.getY() > -0.2) {
            Robot.driveTrain.driveTrainSpin(OI.joystick.getX());
       } else if(OI.joystick.getX() > 0) {
            Robot.driveTrain.driveTrainSpinAndMove(DriveTrain.turnMag(OI.joystick.getX(), OI.joystick.getY()), DriveTrain.moveMag(OI.joystick.getY())); 
       } else if(OI.joystick.getX() < 0) {
            Robot.driveTrain.driveTrainSpinAndMove(DriveTrain.moveMag(OI.joystick.getY()), DriveTrain.turnMag(OI.joystick.getX(), OI.joystick.getY()));
        }
        */
    }
}