package org.frc5587.bunnybots.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.frc5587.bunnybots.Constants;
import org.frc5587.bunnybots.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {

    private DoubleSolenoid pistonClaw = new DoubleSolenoid(RobotMap.Claw.PISTON_CLAW[0],
            RobotMap.Claw.PISTON_CLAW[1]);
    private TalonSRX clawArm = new TalonSRX(RobotMap.Claw.TALON);
    private static final double ticksPerNinety = -3219.0;

    public Claw() {
        configureTalon();
    }

    private void configureTalon() {
        // Choose sensor type
        clawArm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.ClawArm.kPIDLoopIdx,
                Constants.ClawArm.kTimeoutMs);
        clawArm.setSensorPhase(true);
        clawArm.setInverted(false);
        // elevatorVictorSPX.setInverted(false);
        // Set relevant frame periods to be at least as fast as periodic rate
        clawArm.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.ClawArm.kTimeoutMs);
        clawArm.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.ClawArm.kTimeoutMs);

        // set the peak and nominal outputs
        clawArm.configNominalOutputForward(Constants.ClawArm.minPercentOut, Constants.ClawArm.kTimeoutMs);
        clawArm.configNominalOutputReverse(-Constants.ClawArm.minPercentOut, Constants.ClawArm.kTimeoutMs);
        clawArm.configPeakOutputForward(Constants.ClawArm.maxPercentFw, Constants.ClawArm.kTimeoutMs);
        clawArm.configPeakOutputReverse(-Constants.ClawArm.maxPercentBw, Constants.ClawArm.kTimeoutMs);

        clawArm.configPeakCurrentLimit(40, Constants.ClawArm.kTimeoutMs);
        clawArm.configPeakCurrentDuration(200, Constants.ClawArm.kTimeoutMs);
        clawArm.configContinuousCurrentLimit(35, Constants.ClawArm.kTimeoutMs);

        // set closed loop gains in set slot
        clawArm.selectProfileSlot(Constants.ClawArm.kSlotIdx, Constants.ClawArm.kPIDLoopIdx);
        clawArm.config_kF(0, Constants.ClawArm.kF, Constants.ClawArm.kTimeoutMs);
        clawArm.config_kP(0, Constants.ClawArm.kP, Constants.ClawArm.kTimeoutMs);
        clawArm.config_kI(0, Constants.ClawArm.kI, Constants.ClawArm.kTimeoutMs);
        clawArm.config_kD(0, Constants.ClawArm.kD, Constants.ClawArm.kTimeoutMs);
        // set acceleration and vcruise velocity - see documentation
        clawArm.configMotionCruiseVelocity(Constants.ClawArm.maxVelocity, Constants.ClawArm.kTimeoutMs);
        clawArm.configMotionAcceleration(Constants.ClawArm.maxAcceleration, Constants.ClawArm.kTimeoutMs);
        // zero the sensor
        // clawArm.setSelectedSensorPosition(0, Constants.ClawArm.kPIDLoopIdx,
        // Constants.ClawArm.kTimeoutMs);
        clawArm.configVoltageCompSaturation(Constants.ClawArm.vCompSaturation, Constants.ClawArm.kTimeoutMs);
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