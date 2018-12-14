package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class ResetArmEncoder extends InstantCommand {
    public ResetArmEncoder() {
        this.setRunWhenDisabled(true);
    }

    @Override
    protected void execute() {
        Robot.claw.resetEncoder();
    }

}