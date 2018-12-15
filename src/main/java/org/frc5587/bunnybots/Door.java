package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Door extends Subsystem {

    private Servo servo = new Servo(RobotMap.Door.SERVO);

    public Door() {

    }

    // servos can be set in either degrees or pwm (0.0 - 1.0)
    public void doorClose() {
        servo.set(0.0);
    }

    public void doorOpen() {
        servo.set(1.0);
    }

    @Override
    protected void initDefaultCommand() {

    }
}