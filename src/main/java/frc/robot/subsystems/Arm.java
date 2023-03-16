// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.ARM_IDLE_TYPE;
import static frc.robot.Constants.OperatorConstants.ARM_MOTOR;
import static frc.robot.Constants.OperatorConstants.ARM_MOTOR_TYPE;
import static frc.robot.Constants.OperatorConstants.ARM_SPEED;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.SoftLimitDirection;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  private final CANSparkMax m_armMotor = new CANSparkMax(ARM_MOTOR, ARM_MOTOR_TYPE);

  /** 
   * Creates a new Arm subsystem.
   * 
   * Uses the REV SparkMax controller.
   * Has soft limits to stop at high and middle goal.
   * Has the claw attached to the end of it.
   */
  public Arm() {
    m_armMotor.restoreFactoryDefaults();
    // m_armMotor.setInverted(true);
    // Arm limits
    // m_armDrive.setSmartCurrentLimit(60);
    m_armMotor.setIdleMode(ARM_IDLE_TYPE);

    // enable soft limits
    m_armMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    m_armMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);

    // default soft limits
    m_armMotor.setSoftLimit(SoftLimitDirection.kForward, 50);
    m_armMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
  }

  // extend arm to middle height
  public void middleLimit() {
    m_armMotor.setSoftLimit(SoftLimitDirection.kForward, 41); //25 for auto
  }

  // extend arm to highest height
  public void highLimit() {
    m_armMotor.setSoftLimit(SoftLimitDirection.kForward, 50);
  }

  public void automiddleLimit() {
    m_armMotor.setSoftLimit(SoftLimitDirection.kForward, 41);
  }

  public void autohighLimit() {
    m_armMotor.setSoftLimit(SoftLimitDirection.kForward, 50);
  }

  // default extend speed
  public void extend() {
    m_armMotor.set(ARM_SPEED);
    //System.out.println(m_armMotor.getOutputCurrent());
  }

  // custom extend speed
  public void extend(double speed) {
    m_armMotor.set(Math.abs(speed));
  }

  // default retract speed
  public void retract() {
    m_armMotor.set(-ARM_SPEED);
  }

  // custom retract speed
  public void retract(double speed) {
    m_armMotor.set(-Math.abs(speed));
  }

  public void retractNolimit() {
    m_armMotor.setSoftLimit(SoftLimitDirection.kReverse, -9999999);
    retract();
  }
  
  // stops the arm
  public void stop() {
    m_armMotor.set(0);
    m_armMotor.setSoftLimit(SoftLimitDirection.kForward, 50);
    m_armMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);
  }

  public double output() {
    return m_armMotor.getAppliedOutput();
  }

  public double getEncoder() {
    double pos = m_armMotor.getEncoder().getPosition();
    return pos;
  } 

  public void moveArm(double endpos) {
    m_armMotor.getEncoder().setPosition(endpos);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run  
  }
}
