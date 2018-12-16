package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.OI;
import org.frc5587.bunnybots.Robot;
import org.frc5587.bunnybots.subsystems.Claw;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlClaw extends Command {
    private int count = 1;
    private double point;

    public ControlClaw() {
        point = 0;
    }

    @Override
    protected void execute() {
        Robot.claw.updateFeed();

        // open/close claw (toggle)
        if (OI.controller.getBButton()) {
            Robot.claw.clawClose();
        } else {
            Robot.claw.clawOpen();
        }
        
        // move claw up/down
        if (!OI.controller.getXButton()) {
            // control via setpoints -- cycles through
            if (OI.controller.getBumperPressed(Hand.kLeft)) {
                if (count == 1) {
                    point = Claw.degreeConversion(-15);
                } else if (count == 2) {
                    point = Claw.degreeConversion(0);
                } else if (count == 3) {
                    point = Claw.degreeConversion(45);
                } else if (count == 4) {
                    point = Claw.degreeConversion(90)
;                }

                if (count >= 4) {
                    count = 1;
                } else {
                    count++;
                }
                Robot.claw.moveToSetPoint(point);
            }
        } else {
            // manual control
            if (Math.abs(OI.controller.getY(Hand.kLeft)) > .05) {
                Robot.claw.clawArmMove(.25 * OI.controller.getY(Hand.kLeft));
            } else {
                // hold voltage
                Robot.claw.clawArmMove(-0.07);
            }
        }
        
        SmartDashboard.putNumber("Claw Arm Encoder Value: ", Robot.claw.getArmPosition());
    }
    

    @Override
    protected boolean isFinished() {
        return false;
    }
}