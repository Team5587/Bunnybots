package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.OI;
import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlIntake extends Command {
    private boolean on, indexerTriggered;
    private Timer indexerTimer;
    private double timeInterval;

    public ControlIntake() {
        on = false;
        indexerTriggered = true;
        indexerTimer = new Timer();
    }

    @Override
    protected void initialize() {
        indexerTimer.start();
    }

    @Override
    protected void execute() {
        // using getBumper as opposed to getBumperPressed for more specific control
        if (OI.controller.getBumperPressed(Hand.kRight)) {
            if (OI.controller.getStickButton(Hand.kRight)) {
                Robot.intake.intakeBack();
            } else {
                if (!on) {
                    Robot.intake.intakeOn();
                    on = true;
                } else {
                    Robot.intake.intakeOff();
                    on = false;
                }
            } 
        }

        if (on) {
            timeInterval = indexerTriggered ? 0.7 : 0.2;

            if (indexerTimer.hasPeriodPassed(timeInterval)) { // toggle indexer every time interval
                if (indexerTriggered) {
                    Robot.sorter.setIndexer(DoubleSolenoid.Value.kReverse);
                } else {
                    Robot.sorter.setIndexer(DoubleSolenoid.Value.kForward);
                }
                indexerTriggered = !indexerTriggered;
                indexerTimer.reset();
            }
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}