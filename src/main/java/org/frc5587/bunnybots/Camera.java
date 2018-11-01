package org.frc5587.bunnybots;


public class Camera {
    // public static final int DRIVER_CAMERA = 0;
    // public static final int GRABBER_CAMERA = 1;
    private Camera driverCamera = new Camera(0);
    private Camera grabberCamera = new Camera(1);

    public Camera() {
    }
}