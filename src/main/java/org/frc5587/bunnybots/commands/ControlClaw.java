package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.OI;
import org.frc5587.bunnybots.Robot;
import org.frc5587.bunnybots.subsystems.Claw;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlClaw extends Command {

    public ControlClaw() {

    }



    @Override
    protected void execute() {

        if (OI.controller.getBButtonPressed()) {
            Robot.claw.clawClose();
        } else if (OI.controller.getXButtonPressed()) {
            Robot.claw.clawOpen();
        }
        
        if (!OI.controller.getXButton()) {
            if (OI.controller.getBumperPressed(Hand.kLeft)) {
                Robot.claw.moveToSetPoint(Claw.degreeConversion(80));
            } else if (OI.controller.getTrigger(Hand.kLeft)) {
                Robot.claw.moveToSetPoint(Claw.degreeConversion(0));
            }
        } else {
            if (Math.abs(OI.controller.getY(Hand.kLeft)) > .05) {
                Robot.claw.clawArmMove(.25 * OI.controller.getY(Hand.kLeft));
            } else {
                Robot.claw.clawArmMove(-0.07);
            }
        }

        System.out.println(Robot.claw.getArmPosition());
        SmartDashboard.putNumber("Claw Arm Encoder Value: ", Robot.claw.getArmPosition());

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}