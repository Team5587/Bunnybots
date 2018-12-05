package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {


    public DoubleSolenoid pistonClaw = new DoubleSolenoid(RobotMap.OriginalClaw.PISTON_CLAW[0], RobotMap.OriginalClaw.PISTON_CLAW[1] );

    public Claw() {

    }

    public void clawClose() {
        pistonClaw.set(DoubleSolenoid.Value.kForward);
    }

    public void clawOpen() {
        pistonClaw.set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    protected void initDefaultCommand() {

    }
}