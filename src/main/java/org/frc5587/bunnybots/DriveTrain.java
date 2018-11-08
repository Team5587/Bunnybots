package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    private TalonSRX leftMaster = new TalonSRX(1);
    private TalonSRX rightMaster = new TalonSRX(2);
    private VictorSPX leftSlave = new VictorSPX(3);
    private VictorSPX rightSlave = new VictorSPX(4);

    private static double percentDecrease = .7;

    public DriveTrain() {
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightMaster.setNeutralMode(NeutralMode.Brake);
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
        leftMaster.set(ControlMode.PercentOutput, -leftIn);
        rightMaster.set(ControlMode.PercentOutput, rightIn);
    }

    
    public static double turnMag(double xIn, double yIn) {
        double turnAmt = (Math.abs(yIn * percentDecrease) + Math.abs(xIn * (2 - percentDecrease))) * (yIn / Math.abs(yIn));
        return turnAmt;
    }

    public static double moveMag(double yIn) {
        yIn *= percentDecrease;
        return yIn;
    }

    @Override
    protected void initDefaultCommand() {
        
    }

}