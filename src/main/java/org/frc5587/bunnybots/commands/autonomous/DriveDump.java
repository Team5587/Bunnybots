package org.frc5587.bunnybots.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveDump extends CommandGroup {

    public DriveDump() {
        addSequential(new AutoForward());
        addSequential(new AutoPointTurn());
        addSequential(new AutoDoor());
    }

}