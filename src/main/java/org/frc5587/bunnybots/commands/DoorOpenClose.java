package org.frc5587.bunnybots.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DoorOpenClose extends Command {
    private Timer timerTwo = new Timer();

    public DoorOpenClose() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}