package org.frc5587.bunnybots;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BottomText extends Subsystem {
    private TalonSRX ligma;
    private Joystick sugma;
    private TalonSRX sugandese;

    public BottomText() {
        this.ligma = new TalonSRX(5);
        this.sugma = new Joystick(2);
        this.sugandese = new TalonSRX(7);
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void noNutNovember() {
        double poop = sugma.getY();
        ligma.set(ControlMode.PercentOutput, poop);
        
        double pee = sugma.getX();
        sugandese.set(ControlMode.PercentOutput, pee);

    }

}
