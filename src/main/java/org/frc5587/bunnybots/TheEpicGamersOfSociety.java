package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class TheEpicGamersOfSociety extends Command {

    public TheEpicGamersOfSociety() {

    }

    @Override
    protected void execute() {
        Robot.mitochondria.noNutNovember();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
