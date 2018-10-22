package org.frc5587.bunnybots.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.frc5587.bunnybots.OI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;

public class  ControlHatch extends Command{
    DoubleSolenoid hatch;
    Joystick jb;
    Compressor c;

    public ControlHatch(){
       hatch = new DoubleSolenoid(1, 2);
    }

    protected void initialize() {
        jb = OI.jb;
        c = new Compressor(0);
    }

    protected void execute() {
       c.setClosedLoopControl(true);

       if(jb.getRawButton(1)){
            hatch.set(DoubleSolenoid.Value.kForward);
       }else if(jb.getRawButton(2)){
            hatch.set(DoubleSolenoid.Value.kReverse);
       }else{
        hatch.set(DoubleSolenoid.Value.kOff);
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