package org.frc5587.bunnybots.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.frc5587.bunnybots.OI;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.networktables.*;

public class  ControlHatch extends Command{
    DoubleSolenoid hatch;
    Joystick jb;
    Compressor c;
    // NetworkTableEntry redEntry, blueEntry;
    Boolean red, blue;
    
    public ControlHatch(){
       hatch = new DoubleSolenoid(0,1);
    //    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    //    NetworkTable table = inst.getTable("SmartDashboard");
    //    blueEntry = table.getEntry("Camera 1 Red");
    //    redEntry = table.getEntry("Camera 1 Blue");
    }

    protected void initialize() {
        jb = OI.jb;
        c = new Compressor(0);
        c.setClosedLoopControl(true);
    }

    protected void execute() {
    //    red = redEntry.getBoolean(false);
    //    blue = blueEntry.getBoolean(false);
        red = SmartDashboard.getBoolean("red", false);
        blue = SmartDashboard.getBoolean("blue", false);

        SmartDashboard.putBoolean("Blue on RIO", blue);
        SmartDashboard.putBoolean("Red on RIO", red);

        hatch.set(DoubleSolenoid.Value.kForward);

        if(red){
            hatch.set(DoubleSolenoid.Value.kReverse);
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