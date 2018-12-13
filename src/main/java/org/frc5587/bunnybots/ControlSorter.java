package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ControlSorter extends Command {

    public ControlSorter() {
        requires(Robot.sorter);
    }

    @Override
    protected void execute() {
        boolean isRed = SmartDashboard.getBoolean("Camera Red", false);
        boolean isBlue = SmartDashboard.getBoolean("Camera Blue", false);  
        System.out.println("Red: " + isRed + " / Blue: " + isBlue);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}