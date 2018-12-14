package org.frc5587.bunnybots.commands;


import java.awt.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoPointTurn extends Command{
    private Timer timerOne = new Timer();

    public AutoPointTurn() {
        
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}