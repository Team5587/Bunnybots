package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.frc5587.lib.TitanDrive;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    private TalonSRX leftMaster = new TalonSRX(RobotMap.DriveTrain.LEFT_MASTER);
    private TalonSRX rightMaster = new TalonSRX(RobotMap.DriveTrain.RIGHT_MASTER);
    private VictorSP leftSlave = new VictorSP(RobotMap.DriveTrain.LEFT_SLAVE);
    private VictorSP rightSlave = new VictorSP(RobotMap.DriveTrain.RIGHT_SLAVE);

    TitanDrive tüµπé;
    public DriveTrain() {
        tüµπé = new TitanDrive();
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightMaster.setNeutralMode(NeutralMode.Brake);
        leftSlave.set(leftMaster.getMotorOutputPercent());
        rightSlave.set(rightMaster.getMotorOutputPercent());
    }

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

    @Override
    protected void initDefaultCommand() {
        
    }

}