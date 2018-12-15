package org.frc5587.bunnybots;

/**
 * Constants is a central place in which to store all of the constants having to
 * do with the robot and its subsystems. Where applicable, the constants are
 * stored within subclasses that describe the subsystem with which the constant
 * is associated and/or used.
 */
public class Constants {

    public static boolean compressorEnabled = false;

    public static final class ClawArm {
        // Which PID slot to pull gains from. Starting 2018, you can choose from 0,1,2
        // or 3.
        public static final int kSlotIdx = 0;
        // Talon SRX/Victor SPX will supported multiple (cascaded) PID loops. For now we
        // just want the primary one
        public static final int kPIDLoopIdx = 0;
        // set to zero to skip waiting for confirmation, set to nonzero to wait and
        // report to DS if action fails
        public static final int kTimeoutMs = 10;

        public static final double vCompSaturation = 12.0;

        public static final double holdPercent = 0.2;

        public static final double kDeadband = 200;

        public static final double stallTorqueInchLbs = 12.4;
        public static final double distToCOMInch = 12.0;
        public static final double gearRatio = 15.0;
        public static final double armWeightLbs = 2.4;
        public static final int numMotors = 1;

        // PID Constants
        public static double kP = 0.55, kI = 0.0, kD = 0.05;

        // Safety limits
        public static final double minPercentOut = 0, maxPercentBw = .6, maxPercentFw = 1;

        // System Constraints
        public static final int maxVelocity = 2500; // measured in native units/100ms
        public static final int maxAcceleration = 2500; // measured in native units/100ms/sec
    }
}
