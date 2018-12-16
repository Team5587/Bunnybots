package org.frc5587.bunnybots;

public class RobotMap {
    public static final int COMPRESSOR = 0;

    public static class Claw {
        public static final int[] PISTON_CLAW = { 6, 7 };
        public static final int TALON = 5;
    }

    public static class DriveTrain {
        public static final int LEFT_MASTER = 1;
        public static final int RIGHT_MASTER = 2;
        public static final int LEFT_SLAVE = 3;
        public static final int RIGHT_SLAVE = 4;
    }

    public static class Door {
        // pwm channel to which the servo is connected
        public static final int SERVO = 1;
    }

    public static class Intake {
        // change CAN ID later when we know where it actually is
        public static final int TALON = 9;
    }

    public static class Sorter {
        public static final int[] hatchSolenoid = { 4, 5 };
        public static final int[] indexerSolenoid = { 0, 1 };
    }
}
