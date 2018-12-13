package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sorter extends Subsystem {

    private DoubleSolenoid sorterPiston = new DoubleSolenoid(RobotMap.Sorter.SORTER_PISTON[0], RobotMap.Sorter.SORTER_PISTON[1]);

    public Sorter() {

    }

    public void pistonIn() {
        sorterPiston.set(DoubleSolenoid.Value.kForward);
    }

    public void pistonOut() {
        sorterPiston.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    protected void initDefaultCommand() {
        
    }

}