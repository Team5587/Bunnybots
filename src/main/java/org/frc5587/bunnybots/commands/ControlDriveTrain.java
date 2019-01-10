package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.OI;
import org.frc5587.bunnybots.Robot;
import org.frc5587.lib.TitanDrive;
import org.frc5587.lib.TitanDrive.DriveSignal;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlDriveTrain extends Command {

    public ControlDriveTrain() {
        requires(Robot.driveTrain);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {

        DriveSignal energizerBunny = TitanDrive.arcadeDrive(OI.xb.getY(Hand.kLeft), -OI.xb.getX(Hand.kLeft));
        Robot.driveTrain.vbusLR(energizerBunny.left, energizerBunny.right);
    }

}