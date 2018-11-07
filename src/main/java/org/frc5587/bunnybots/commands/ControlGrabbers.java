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
        if (OI.controller.getYButton()) {
            Robot.grabbers.grabberOut();
        } else if(OI.controller.getXButton()) {
            Robot.grabbers.grabberIn();
        } else {
            Robot.grabbers.grabberStop();
        }


        if(OI.controller.getBumper(Hand.kRight)) {
            Robot.grabbers.grabberOpen();
        } else{
            Robot.grabbers.grabberClose();
        } 
    }
    
}