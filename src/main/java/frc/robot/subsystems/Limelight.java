// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  // Creates a "Network Table" which contains data from limelight
  // Check: https://docs.limelightvision.io/en/latest/networktables_api.html
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public NetworkTableEntry tid = table.getEntry("tid");
  public NetworkTableEntry tx = table.getEntry("tx");
  public NetworkTableEntry ty = table.getEntry("ty");
  public NetworkTableEntry ta = table.getEntry("ta");
  public NetworkTableEntry led = table.getEntry("ledMode");
  public NetworkTableEntry cam = table.getEntry("camMode");
  
  // retrieves ID of AprilTag
  public double getID() {
    return tid.getDouble(0.0);
  }

  // retrives horizontal position of AprilTag relative to crosshair
  public double getXPosition() {
    return tx.getDouble(0.0);
  }

  // retrieves vertical position of AprilTag relative to crosshair
  public double getYPosition() {
    return ty.getDouble(0.0);
  }

  // retrieves area AprilTag fills in limelight screen
  public double getArea() {
    return ta.getDouble(0.0);
  }

  public void togglelight() {
    double num = led.getDouble(0);
    if (num == 1.0) {
      led.setNumber((Number)3);
    }
    else if (num == 3.0){
      led.setNumber((Number)1);
    }
  }

  public void toggleCamMode() {
    double num = cam.getDouble(0);
    if (num == 0) {
      cam.setNumber((Number)1);
    }
    else if (num == 1) {
      cam.setNumber((Number)0);
    }
  }

  @Override
  public void periodic(){
    // This method will be called once per scheduler run
  }
}
