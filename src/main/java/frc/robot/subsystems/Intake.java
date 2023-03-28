// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.TALON_CHANNEL;
import static frc.robot.Constants.OperatorConstants.INTAKE_SPEED;
import static frc.robot.Constants.OperatorConstants.INTAKE_MOTOR_TYPE;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private CANSparkMax neo550 = new CANSparkMax(TALON_CHANNEL, INTAKE_MOTOR_TYPE);
  private WPI_TalonSRX talon = new WPI_TalonSRX(TALON_CHANNEL);


  /** Creates a new Intake. */
  public Intake() {
    neo550.restoreFactoryDefaults();

    neo550.setSmartCurrentLimit(20);
  }

  public void pickUp() {
    neo550.set(INTAKE_SPEED);
    System.out.println(talon.getMotorOutputVoltage());
  }

  public void place() {
    neo550.set(-INTAKE_SPEED);
  }

  public void stop() {
    neo550.set(0);
  }

  public WPI_TalonSRX talonMotor() {
    return talon;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
