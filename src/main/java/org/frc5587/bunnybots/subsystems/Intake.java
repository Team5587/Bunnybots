package org.frc5587.bunnybots.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import org.frc5587.bunnybots.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
    private VictorSP roller;

    public Intake() {
        roller = new VictorSP(0);
    }

    public void initDefaultCommand() {
    }

    public void spinRollers(double rollerSpeed){
        roller.set(rollerSpeed);
    }
}
