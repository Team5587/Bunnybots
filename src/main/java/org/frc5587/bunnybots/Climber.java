package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{

    private TalonSRX climberTalon = new TalonSRX(9);

    public Climber(){
    }

    public void climberUp() {
        climberTalon.set(ControlMode.PercentOutput, 1);
    } 

    @Override
    protected void initDefaultCommand() {

    }

}