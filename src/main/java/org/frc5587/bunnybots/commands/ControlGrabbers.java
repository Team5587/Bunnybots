package org.frc5587.bunnybots.commands;

import org.frc5587.bunnybots.*;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class ControlGrabbers extends Command{
    Grabbers grabber;

    public ControlGrabbers(){

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void execute() {
        if (OI.controller.getYButtonPressed()) {
            Robot.grabbers.grabberOut();
        }
        if(OI.controller.getXButtonPressed()) {
            Robot.grabbers.grabberIn();
        }
        if(OI.controller.getBumper(Hand.kRight)) {
            Robot.grabbers.grabberOpen();
        }
        if(OI.controller.getBumper(Hand.kLeft)) {
            Robot.grabbers.grabberClose();
        }
    }
    
}