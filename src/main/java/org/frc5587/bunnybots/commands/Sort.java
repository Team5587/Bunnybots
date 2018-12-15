package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.subsystems.Sorter;
import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Sort extends Command {
    private Boolean red, blue, indexerTriggered;
    private Sorter sorter;
    private Timer hatchTimer, indexerTimer;
    private double timeInterval;

    public Sort() {
        requires(Robot.sorter);
        sorter = Robot.sorter;
        indexerTimer = new Timer();
        hatchTimer = new Timer();
    }

    protected void initialize() {
        indexerTimer.start();
        indexerTriggered = true;
    }

    protected void execute() {
        timeInterval = indexerTriggered ? 0.2 : 0.5;

        if (indexerTimer.hasPeriodPassed(timeInterval)) { // toggle indexer every time interval
            if (indexerTriggered) {
                sorter.setIndexer(DoubleSolenoid.Value.kReverse);
            } else {
                sorter.setIndexer(DoubleSolenoid.Value.kForward);
            }
            indexerTriggered = !indexerTriggered;
            indexerTimer.reset();
        }

        // Backup code just in case the switching above doesn't work
        // if (indexerTriggered) {
        //     if (indexerTimer.hasPeriodPassed(0.2)) {
        //         sorter.setIndexer(DoubleSolenoid.Value.kReverse);
        //         indexerTriggered = !indexerTriggered;
        //         indexerTimer.reset();
        //     }
        // } else {
        //     if (indexerTimer.hasPeriodPassed(0.5)) {
        //         sorter.setIndexer(DoubleSolenoid.Value.kForward);
        //         indexerTriggered = !indexerTriggered;
        //         indexerTimer.reset();
        //     }
        // }

        // Color can be "None", "Red", or "Blue"
        red = (sorter.getResult() == "Red");
        blue = (sorter.getResult() == "Blue");

        if (DriverStation.getInstance().getAlliance() == Alliance.Blue) {
            if (blue) { // if blue open hatch
                sorter.setHatch(DoubleSolenoid.Value.kReverse);
                hatchTimer.start();
            } else if (hatchTimer.hasPeriodPassed(0.5)) { // else open door
                sorter.setHatch(DoubleSolenoid.Value.kForward);
                hatchTimer.stop();
            }
        } else if (DriverStation.getInstance().getAlliance() == Alliance.Red) {
            if (red) { // if red open hatch
                sorter.setHatch(DoubleSolenoid.Value.kReverse);
                hatchTimer.start();
            } else if (hatchTimer.hasPeriodPassed(0.5)) { // else open door
                sorter.setHatch(DoubleSolenoid.Value.kForward);
                hatchTimer.stop();
            }
        }
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