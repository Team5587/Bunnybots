package org.frc5587.bunnybots.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DumpDrive extends CommandGroup {

    public DumpDrive() {
        addSequential(new AutoDoor());

        // addParallel(new RunIntake());
        addSequential(new AutoForward());

        // addSequential(new StopIntake());
    }

}