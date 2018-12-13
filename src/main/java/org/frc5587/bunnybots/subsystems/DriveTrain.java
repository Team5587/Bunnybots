package org.frc5587.bunnybots.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import org.frc5587.bunnybots.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
    private TalonSRX leftMaster = new TalonSRX(RobotMap.DriveTrain.LEFT_MASTER);
    private TalonSRX rightMaster = new TalonSRX(RobotMap.DriveTrain.RIGHT_MASTER);
    private VictorSPX leftSlave = new VictorSPX(RobotMap.DriveTrain.LEFT_SLAVE);
    private VictorSPX rightSlave = new VictorSPX(RobotMap.DriveTrain.RIGHT_SLAVE);

    public DriveTrain() {
        leftMaster.setNeutralMode(NeutralMode.Brake);
        rightMaster.setNeutralMode(NeutralMode.Brake);
        leftMaster.setInverted(true);
        leftSlave.setInverted(true);

        leftSlave.follow(leftMaster);
        rightSlave.follow(rightMaster);
    }

    public void driveTrainMove(double yInput) {
        leftMaster.set(ControlMode.PercentOutput, yInput);
        rightMaster.set(ControlMode.PercentOutput, yInput);
    }

    public void driveTrainSpin(double xInput) {
        leftMaster.set(ControlMode.PercentOutput, xInput);
        rightMaster.set(ControlMode.PercentOutput, xInput);
    }

    public void vbusLR(double leftIn, double rightIn) {
        leftMaster.set(ControlMode.PercentOutput, leftIn);
        rightMaster.set(ControlMode.PercentOutput, rightIn);
    }

    @Override
    protected void initDefaultCommand() {

    }

}