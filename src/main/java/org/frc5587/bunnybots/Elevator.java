package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

    private TalonSRX elevatorTalon = new TalonSRX(7);
    private Solenoid elevatorSolenoid = new Solenoid(2, 3);

    private

    public Elevator() {
    }

    public void elevatorUp() {
        elevatorTalon.set(ControlMode.PercentOutput, 1);
    }

    public void elevatorDown() {
        elevatorTalon.set(ControlMode.PercentOutput, -1);
    }

    public void elevatorDeploy() {
        elevatorSolenoid.set(true);

    }

    public void elevatorBackward() {
        elevatorSolenoid.set(true);
    }

    @Override
    protected void initDefaultCommand() {

    }

}