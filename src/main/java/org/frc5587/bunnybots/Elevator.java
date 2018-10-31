package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

    private TalonSRX motorController = new TalonSRX(7);
    private Solenoid solenoid = new Solenoid(2, 3);
    private XboxController controller = new XboxController(0);

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