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

    int count = 1;
    double point;
    boolean closed = true;

    @Override
    protected void execute() {

        // open/close claw (toggle)
        if (OI.controller.getBButtonPressed()) {
            if (closed) {
                Robot.claw.clawOpen();
                closed = false;
            } else {
                Robot.claw.clawClose();
                closed = true;
            }
        }
        
        // move claw up/down
        if (!OI.controller.getXButton()) {
            // control via setpoints -- cycles through
            if (OI.controller.getBumperPressed(Hand.kLeft)) {
                point = 0;
                if (count == 1) {
                    point = Claw.degreeConversion(-15);
                    count++;
                } else if (count == 2) {
                    point = Claw.degreeConversion(0);
                    count++;
                } else if (count == 3) {
                    point = Claw.degreeConversion(45);
                    count++;
                } else if (count == 4) {
                    point = Claw.degreeConversion(90)
;                }
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

        System.out.println(Robot.claw.getArmPosition());
        SmartDashboard.putNumber("Claw Arm Encoder Value: ", Robot.claw.getArmPosition());
    }
    

    @Override
    protected boolean isFinished() {
        return false;
    }
}