package org.frc5587.bunnybots.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;

import org.frc5587.bunnybots.RobotMap;

public class Sorter extends Subsystem {
    private DoubleSolenoid hatch, indexer;

    public Sorter() {
        hatch = new DoubleSolenoid(RobotMap.Sorter.hatchSolenoid[0], RobotMap.Sorter.hatchSolenoid[1]);
        indexer = new DoubleSolenoid(RobotMap.Sorter.indexerSolenoid[0], RobotMap.Sorter.indexerSolenoid[1]);
    }

    public void initDefaultCommand() {
    }

    public String getResult() {
        return SmartDashboard.getString("Color", "None");
    }

    public void setHatch(DoubleSolenoid.Value valueToSet) {
        hatch.set(valueToSet);
    }

    public void setIndexer(DoubleSolenoid.Value valueToSet) {
        indexer.set(valueToSet);
    }
}
