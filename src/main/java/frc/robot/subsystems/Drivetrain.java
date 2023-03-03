// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private final CANSparkMax m_leftFrontDrive = new CANSparkMax(DRIVE_LEFT_FRONT_MOTOR, DRIVE_MOTOR_TYPE);
  private final CANSparkMax m_leftBackDrive = new CANSparkMax(DRIVE_LEFT_BACK_MOTOR, DRIVE_MOTOR_TYPE);
  private final MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftFrontDrive, m_leftBackDrive);

  private final CANSparkMax m_rightFrontDrive = new CANSparkMax(DRIVE_RIGHT_FRONT_MOTOR, DRIVE_MOTOR_TYPE);
  private final CANSparkMax m_rightBackDrive = new CANSparkMax(DRIVE_RIGHT_BACK_MOTOR, DRIVE_MOTOR_TYPE);
  public final MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightFrontDrive, m_rightBackDrive);

  private DifferentialDrive m_roboDrive = null;

  /** 
   * Creates a new Drivetrain subsystem.
   * 
   * Arcade drive based drivetrain with REV SparkMax controllers.
   */
  public Drivetrain() {
    m_leftFrontDrive.restoreFactoryDefaults();
    m_leftBackDrive.restoreFactoryDefaults();
    m_rightFrontDrive.restoreFactoryDefaults();
    m_rightBackDrive.restoreFactoryDefaults();

    // set right motors to be inverted/reversed
    m_leftDrive.setInverted(false);
    m_rightDrive.setInverted(true);

    // set current limits
    m_leftFrontDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_leftBackDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_rightFrontDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_rightBackDrive.setSmartCurrentLimit(DRIVE_CURRENT);

    // m_leftFrontDrive.setSecondaryCurrentLimit(CURRENT);
    // m_leftBackDrive.setSecondaryCurrentLimit(CURRENT);
    // m_rightFrontDrive.setSecondaryCurrentLimit(CURRENT);
    // m_rightBackDrive.setSecondaryCurrentLimit(CURRENT);

    // set idle behavior
    m_leftFrontDrive.setIdleMode(DRIVE_IDLE_TYPE);
    m_leftBackDrive.setIdleMode(DRIVE_IDLE_TYPE);
    m_rightFrontDrive.setIdleMode(DRIVE_IDLE_TYPE);
    m_rightBackDrive.setIdleMode(DRIVE_IDLE_TYPE);

    m_roboDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    m_roboDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
  
  public double[] getDriveEncoder() {
    double[] arr = new double[2];
    arr[0] = m_leftFrontDrive.getEncoder().getPosition();
    arr[1] = -m_rightFrontDrive.getEncoder().getPosition();
    return arr;
  }

  public void moveLeftMotors(double speed) {
    m_leftDrive.set(speed);
  }

  public void moveRightMotors(double speed) {
    //m_rightDrive.setInverted(false);
    m_rightDrive.set(speed);
  }

  public void stop() {
    arcadeDrive(0, 0);
  }

  public void turbo() {
    DRIVE_FACTOR = 1;
  }

  public void unturbo() {
    DRIVE_FACTOR = .5;
  }

  public void reverseDirection() {
    DRIVE_REVERSE *= -1;
    DRIVE_TURN *= -1;
    //DRIVE_REVERSE_TURN *= -1;
  }

  public void normalDirection() {
    DRIVE_REVERSE *= -1;
    DRIVE_TURN *= -1;
    //DRIVE_REVERSE_TURN *= 1;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

