// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.TALON_CHANNEL;
import static frc.robot.Constants.OperatorConstants.INTAKE_SPEED;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private WPI_TalonSRX talon = new WPI_TalonSRX(TALON_CHANNEL);

  /** Creates a new Intake. */
  public Intake() {
    talon.configFactoryDefault();
  }

  public void spin() {
    talon.set(INTAKE_SPEED);
    System.out.println(talon.getMotorOutputVoltage());
  }

  public void stop() {
    talon.set(0);
  }

  public WPI_TalonSRX talonMotor() {
    return talon;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
