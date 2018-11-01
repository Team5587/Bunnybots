package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Elevator extends Subsystem {

    private TalonSRX elevatorTalon = new TalonSRX(7);
    private DoubleSolenoid elevatorSolenoid = new DoubleSolenoid(2, 3);
    private Compressor elevatorCompressor = new Compressor();

    // private

    public Elevator() {
    }

    public void elevatorUp() {
        elevatorTalon.set(ControlMode.PercentOutput, 1);
    }

    public void elevatorDown() {
        elevatorTalon.set(ControlMode.PercentOutput, -1);
    }

    public void elevatorDeploy() {
        elevatorCompressor.start();
        elevatorSolenoid.set(true);

    }

    public void elevatorBackward() {
        elevatorCompressor.start();
        elevatorSolenoid.set(true);
    }

    @Override
    protected void initDefaultCommand() {

    }

}