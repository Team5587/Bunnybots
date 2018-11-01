package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Grabbers extends Subsystem{

    public Grabbers(){

    }

    private DoubleSolenoid expanderSolenoid = new DoubleSolenoid(1, 0);
    private TalonSRX leftTalon = new TalonSRX(6), rightTalon = new TalonSRX(5);

    public void grabberOpen(){
        expanderSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void grabberClose(){
        expanderSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void grabberIn(){
        leftTalon.set(ControlMode.PercentOutput, 1);
        rightTalon.set(ControlMode.PercentOutput, -1);
    }

    public void grabberOut(){
        leftTalon.set(ControlMode.PercentOutput, -1);
        rightTalon.set(ControlMode.PercentOutput, 1);
    }

    @Override
    protected void initDefaultCommand() {

    }
}