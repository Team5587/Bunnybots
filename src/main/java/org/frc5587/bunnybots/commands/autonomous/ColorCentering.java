package org.frc5587.bunnybots.commands.autonomous;

import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ColorCentering extends Command {
    private static double frameWidth = 320.0;
    private static double widthTolerance = 25.0; // used as +/-

    public ColorCentering() {
        // Use requires() here to declare subsystem dependencies
        // requires(Robot.exampleSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double dist = SmartDashboard.getNumber("Px From Crate", 0.0);

        // If dist is not within -widthTolerance to +widthTolerance range, use it
        if (dist > widthTolerance || dist < -widthTolerance) {
            double mappedDist = map(dist, -frameWidth, frameWidth, -1, 1);
            Robot.driveTrain.driveTrainSpin(0.3 * mappedDist);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.driveTrain.driveTrainSpin(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        Robot.driveTrain.driveTrainSpin(0);
    }

    private static double map(double x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}