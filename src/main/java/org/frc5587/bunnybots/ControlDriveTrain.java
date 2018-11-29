package org.frc5587.bunnybots;


import org.frc5587.lib.TitanDrive;
import org.frc5587.lib.TitanDrive.DriveSignal;

import edu.wpi.first.wpilibj.command.Command;

public class ControlDriveTrain extends Command {
    private TitanDrive tüµπé = new TitanDrive();

    public ControlDriveTrain() {
        requires(Robot.driveTrain);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {

        DriveSignal energizerBunny = tüµπé.arcadeDrive(OI.joystick.getY(), -OI.joystick.getX());
        Robot.driveTrain.driveTrainSpinAndMove(energizerBunny.left, energizerBunny.right);
    }

}