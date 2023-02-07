// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final CANSparkMax m_leftFrontDrive = new CANSparkMax(DRIVE_LEFT_FRONT_MOTOR, DRIVE_MOTOR_TYPE);
  private final CANSparkMax m_leftBackDrive = new CANSparkMax(DRIVE_LEFT_BACK_MOTOR, DRIVE_MOTOR_TYPE);
  private final MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftFrontDrive, m_leftBackDrive);

  private final CANSparkMax m_rightFrontDrive = new CANSparkMax(DRIVE_RIGHT_FRONT_MOTOR, DRIVE_MOTOR_TYPE);
  private final CANSparkMax m_rightBackDrive = new CANSparkMax(DRIVE_RIGHT_BACK_MOTOR, DRIVE_MOTOR_TYPE);
  private final MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightFrontDrive, m_rightBackDrive);

  private DifferentialDrive m_roboDrive;
  private final Timer m_Timer = new Timer();

  /** Creates a new DriveTrain. */
  public DriveTrain() {

    m_leftFrontDrive.restoreFactoryDefaults();
    m_leftBackDrive.restoreFactoryDefaults();
    m_rightFrontDrive.restoreFactoryDefaults();
    m_rightBackDrive.restoreFactoryDefaults();

    // set left or right motors to be inverted/reversed
    boolean reverse = true;
    m_leftFrontDrive.setInverted(reverse);
    m_leftBackDrive.setInverted(reverse);
    m_rightFrontDrive.setInverted(!reverse);
    m_rightBackDrive.setInverted(!reverse);

    // m_leftBackDrive.follow(m_leftFrontDrive);
    // m_rightBackDrive.follow(m_rightFrontDrive);

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

    // save config to memory
    m_leftFrontDrive.burnFlash();
    m_leftBackDrive.burnFlash();
    m_rightFrontDrive.burnFlash();
    m_rightBackDrive.burnFlash();

    m_roboDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    m_roboDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
