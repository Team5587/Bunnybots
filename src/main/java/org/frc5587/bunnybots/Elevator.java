package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

    private TalonSRX motorController = new TalonSRX(7);
    private Solenoid solenoid = new Solenoid(2, 3);

    public Elevator() {
    }

    public void elevatorUp() {
        motorController.set(ControlMode.PercentOutput, 1);
    }

    public void elevatorDown() {
        motorController.set(ControlMode.PercentOutput, -1);
    }

    @Override
    protected void initDefaultCommand() {

    }

}