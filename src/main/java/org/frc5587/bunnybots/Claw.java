package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {

    private DoubleSolenoid pistonClaw = new DoubleSolenoid(RobotMap.Claw.PISTON_CLAW[0],
            RobotMap.Claw.PISTON_CLAW[1]);
    private TalonSRX clawArm = new TalonSRX(RobotMap.Claw.TALON);

    public Claw() {

    }

    public void clawClose() {
        pistonClaw.set(DoubleSolenoid.Value.kForward);
    }

    public void clawOpen() {
        pistonClaw.set(DoubleSolenoid.Value.kReverse);
    }

    public void clawArmMove(double xVal) {
        clawArm.set(ControlMode.PercentOutput, xVal);
    }

    public void clawSetPoints() {
        clawArm.set(ControlMode.PercentOutput, 1);
    }

    @Override
    protected void initDefaultCommand() {

    }
}