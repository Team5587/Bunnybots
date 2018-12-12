package org.frc5587.bunnybots.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.frc5587.bunnybots.OI;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.networktables.*;

public class ControlHatch extends Command {
    DoubleSolenoid hatch;
    Joystick jb;
    Compressor c;
    // NetworkTableEntry redEntry, blueEntry;
    Boolean red, blue;
    Timer switchTimer;

    public ControlHatch() {
        hatch = new DoubleSolenoid(4, 5);
        switchTimer = new Timer();
        // NetworkTableInstance inst = NetworkTableInstance.getDefault();
        // NetworkTable table = inst.getTable("SmartDashboard");
        // blueEntry = table.getEntry("Camera 1 Red");
        // redEntry = table.getEntry("Camera 1 Blue");
    }

    protected void initialize() {
        jb = OI.jb;
        c = new Compressor(0);
        c.setClosedLoopControl(true);
    }

    protected void execute() {
        // red = redEntry.getBoolean(false);
        // blue = blueEntry.getBoolean(false);
        red = SmartDashboard.getBoolean("Camera Red", false);
        blue = SmartDashboard.getBoolean("Camera Blue", false);

        System.out.println("RED: " + red + " | BLUE: " + blue);
        if (blue) {
            hatch.set(DoubleSolenoid.Value.kReverse);
            switchTimer.start();
        } else if (switchTimer.hasPeriodPassed(0.5)) {
            hatch.set(DoubleSolenoid.Value.kForward);
            switchTimer.stop();
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