// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensor extends SubsystemBase {
  // Sets up communication with TalonSRX which allows communication to PigeonIMU
  private WPI_PigeonIMU pigeonIMU = null;

  // Creates a double array with 3 spots.
  public double[] ypr_deg = new double[3];
  
  /** 
   * Creates a new Sensor subsystem.
   * 
   * Uses the PigeonIMU from CTRE
   */
  public Sensor(WPI_TalonSRX talon) {
    pigeonIMU = new WPI_PigeonIMU(talon);
    pigeonIMU.configFactoryDefault();
  }

  public void getYawPitchRoll() {
    pigeonIMU.getYawPitchRoll(ypr_deg);
  }

  public double yaw() {
    return ypr_deg[0];
  }

  public double pitch() {
    return ypr_deg[1];
  }

  public double roll() {
    return ypr_deg[2];
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
