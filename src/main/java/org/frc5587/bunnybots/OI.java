package org.frc5587.bunnybots;

import org.frc5587.lib.DeadbandXboxController;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    public static final DeadbandXboxController controller = new DeadbandXboxController(0);
    public static final Joystick joystick = new Joystick(1);
  
}
