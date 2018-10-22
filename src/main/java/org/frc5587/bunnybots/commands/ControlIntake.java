package org.frc5587.bunnybots.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

import org.frc5587.bunnybots.OI;
import org.frc5587.bunnybots.Robot;
import org.frc5587.bunnybots.subsystems.*;

public class ControlIntake extends Command {
    
    Intake intake; 
    Joystick jb;

    public ControlIntake(){
        requires(Robot.intake);
        intake = Robot.intake;
        // xb = OI.xb;
        jb = OI.jb;
    }

    protected void initialize() {
    }

    protected void execute() {
        intake.spinRollers(-jb.getY());
        // intake.shoot(1.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
        end();
    }
}
