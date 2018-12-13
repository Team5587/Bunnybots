package org.frc5587.bunnybots.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.frc5587.bunnybots.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {

    private DoubleSolenoid pistonClaw = new DoubleSolenoid(RobotMap.Claw.PISTON_CLAW[0],
            RobotMap.Claw.PISTON_CLAW[1]);
    private TalonSRX clawArm = new TalonSRX(RobotMap.Claw.TALON);
    private static final double ticksPerNinety = 3219.0;

    public Claw() {

    }

    public static double degreeConversion(double angle) {
        double encoderTicks = angle * (ticksPerNinety / 90);
        return encoderTicks;
    }

    public static double tickConversion(double ticks) {
        double degrees = ticks * (90 / ticksPerNinety);
        return degrees;
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
        clawArm.set(ControlMode.PercentOutput, .1);
    }

    public double getArmPosition() {
        return clawArm.getSelectedSensorPosition(0);
    }

    public void resetEncoder() {
        clawArm.setSelectedSensorPosition(0, 0, 10);
    }

    public void moveToSetPoint(double encoderTicks) {
        clawArm.set(ControlMode.MotionMagic, encoderTicks);
    }

    @Override
    protected void initDefaultCommand() {

    }
}