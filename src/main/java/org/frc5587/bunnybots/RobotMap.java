package org.frc5587.bunnybots;

public class RobotMap {
    public static final int COMPRESSOR = 0;

    public static class Claw {
        public static final int[] PISTON_CLAW = { 1, 2 };
        public static final int TALON = 3;
    }

    public static class Door {
        // pwm channel to which the servo is connected
        public static final int SERVO = 1;
    }

    public static class Intake {
        // change CAN ID later when we know where it actually is
        public static final int TALON = 2;
    }
}