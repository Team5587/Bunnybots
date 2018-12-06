package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    private TalonSRX leftMaster = new TalonSRX(RobotMap.DriveTrain.LEFT_MASTER);
    private TalonSRX rightMaster = new TalonSRX(RobotMap.DriveTrain.RIGHT_MASTER);
    private VictorSP leftSlave = new VictorSP(RobotMap.DriveTrain.LEFT_SLAVE);
    private VictorSP rightSlave = new VictorSP(RobotMap.DriveTrain.RIGHT_SLAVE);

    public DriveTrain() {
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightMaster.setNeutralMode(NeutralMode.Brake);
    }

    public void driveTrainMove(double yInput) {
        leftMaster.set(ControlMode.PercentOutput, -yInput);
        rightMaster.set(ControlMode.PercentOutput, yInput);
        leftSlave.set(leftMaster.getMotorOutputPercent());
        rightSlave.set(rightMaster.getMotorOutputPercent());
    }

    public void driveTrainSpin(double xInput) {
        leftMaster.set(ControlMode.PercentOutput, xInput);
        rightMaster.set(ControlMode.PercentOutput, xInput);
        leftSlave.set(leftMaster.getMotorOutputPercent());
        rightSlave.set(rightMaster.getMotorOutputPercent());
    }

    public void vbusLR(double leftIn, double rightIn) {
        leftMaster.set(ControlMode.PercentOutput, -leftIn);
        rightMaster.set(ControlMode.PercentOutput, rightIn);
        leftSlave.set(leftMaster.getMotorOutputPercent());
        rightSlave.set(rightMaster.getMotorOutputPercent());
    }

    @Override
    protected void initDefaultCommand() {

    }

}