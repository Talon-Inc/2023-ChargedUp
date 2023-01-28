// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensor extends SubsystemBase {
  // public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  public double[] ypr_deg = new double[3];
  public PigeonIMU _pigeon = new PigeonIMU(8);

  /** Creates a new Sensor. */
  public Sensor() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
