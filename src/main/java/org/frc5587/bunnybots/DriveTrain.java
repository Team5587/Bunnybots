package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveTrain {
    private TalonSRX leftMaster = new TalonSRX(1);
    private TalonSRX rightMaster = new TalonSRX(2);
    private VictorSPX leftSlave = new VictorSPX(3);
    private VictorSPX rightSlave = new VictorSPX(4);

    public DriveTrain() {
    }

    public void driveTrainForward() {
        leftMaster.set(ControlMode.PercentOutput, 1);
        rightMaster.set(ControlMode.PercentOutput, 1);
    }
}