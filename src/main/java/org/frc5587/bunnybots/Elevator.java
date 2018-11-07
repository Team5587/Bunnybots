package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Elevator extends Subsystem{

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

    public void elevatorForward() {
        elevatorCompressor.start();
        elevatorSolenoid.set(DoubleSolenoid.Value.kForward);

    }

    public void elevatorBackward() {
        elevatorCompressor.start();
        elevatorSolenoid.set(DoubleSolenoid.Value.kReverse);
        

    }

    public void elevatorStop() {
        elevatorTalon.set(ControlMode.PercentOutput, 0.15);
    }
    @Override
    protected void initDefaultCommand() {

    }

}