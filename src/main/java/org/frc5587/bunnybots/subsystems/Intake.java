package org.frc5587.bunnybots.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.frc5587.bunnybots.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

    private TalonSRX talon = new TalonSRX(RobotMap.Intake.TALON);

    public Intake() {

    }

    public void intakeOn() {
        talon.set(ControlMode.PercentOutput, 1);
    }

    public void intakeOff() {
        talon.set(ControlMode.PercentOutput, 0);
    }

    @Override
    protected void initDefaultCommand() {
        
    }
}