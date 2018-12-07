package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Door extends Subsystem {
   
    private Servo servo = new Servo(RobotMap.Door.SERVO);
    private static final double openAngle = 135;
    private static final double closedAngle = 0;

    public Door() {

    }

    // servos can be set in either degrees (~ 0 - 180) or pwm (0.0 - 1.0)
    public void doorClose() {
        servo.setAngle(closedAngle);
        // servo.set(0.0);
    }

    public void doorOpen() {
        servo.setAngle(openAngle);
        // servo.set(1.0);
    }


    @Override
    protected void initDefaultCommand() {
        
    }
}