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
    }

    public void driveTrainMove(double yInput) {
        leftMaster.set(ControlMode.PercentOutput, yInput);
        rightMaster.set(ControlMode.PercentOutput, -yInput);
        leftSlave.set(ControlMode.PercentOutput, yInput);
        rightSlave.set(ControlMode.PercentOutput, -yInput);
    }

    @Override
    protected void initDefaultCommand() {
        
    }

}