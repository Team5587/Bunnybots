package org.frc5587.bunnybots;

import edu.wpi.first.wpilibj.CameraServer;

public class Camera {
    private CameraServer driverCamera = new Camera(2);
    private CameraServer grabberCamera = new Camera(3);

    public Camera() {
    }
}