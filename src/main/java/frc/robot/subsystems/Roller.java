// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.ROLLER_MOTOR;
import static frc.robot.Constants.OperatorConstants.ROLLER_SPEED;
import static frc.robot.Constants.OperatorConstants.ROLLER_MOTOR_TYPE;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Roller extends SubsystemBase {
  private CANSparkMax neo550 = new CANSparkMax(ROLLER_MOTOR, ROLLER_MOTOR_TYPE);


  /** Creates a new Roller. */
  public Roller() {
    neo550.restoreFactoryDefaults();

    neo550.setSmartCurrentLimit(20);
    neo550.setIdleMode(IdleMode.kCoast);
  }

  public void pickUp() {
    neo550.set(ROLLER_SPEED);
  }

  public void place() {
    neo550.set(-ROLLER_SPEED);
  }

  public void stop() {
    neo550.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
