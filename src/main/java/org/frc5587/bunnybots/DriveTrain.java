package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    private TalonSRX leftMaster = new TalonSRX(1);
    private TalonSRX rightMaster = new TalonSRX(2);
    private VictorSPX leftSlave = new VictorSPX(3);
    private VictorSPX rightSlave = new VictorSPX(4);

    public DriveTrain() {
        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);
    }

    
    // might need to be flipped, depending on how the motors are set up
    
    public void driveTrainMove(double yInput) {
        leftMaster.set(ControlMode.PercentOutput, -yInput);
        rightMaster.set(ControlMode.PercentOutput, yInput);
    }

    public void driveTrainSpin(double xInput) {
        leftMaster.set(ControlMode.PercentOutput, xInput);
        rightMaster.set(ControlMode.PercentOutput, xInput);
    }
    
    public void driveTrainSpinAndMove(double leftIn, double rightIn) {
        leftMaster.set(ControlMode.PercentOutput, leftIn);
        rightMaster.set(ControlMode.PercentOutput, rightIn);
    }
    
    /*
    // i kinda forget how this is supposed to work (the motor directions)
    public void driveTrainSpin(double xInput) {
        leftMaster.set(ControlMode.PercentOutput, -xInput);
        rightMaster.set(ControlMode.PercentOutput, xInput);
        leftSlave.set(ControlMode.PercentOutput, xInput);
        rightSlave.set(ControlMode.PercentOutput, -xInput);
    }
    */

    @Override
    protected void initDefaultCommand() {
        
    }

}