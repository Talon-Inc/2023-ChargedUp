// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  public CANSparkMax m_leftFrontDrive = new CANSparkMax(DRIVE_LEFT_FRONT_MOTOR, DRIVE_MOTOR_TYPE);
  public CANSparkMax m_leftBackDrive = new CANSparkMax(DRIVE_LEFT_BACK_MOTOR, DRIVE_MOTOR_TYPE);
  private MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftFrontDrive, m_leftBackDrive);

  public CANSparkMax m_rightFrontDrive = new CANSparkMax(DRIVE_RIGHT_FRONT_MOTOR, DRIVE_MOTOR_TYPE);
  private CANSparkMax m_rightBackDrive = new CANSparkMax(DRIVE_RIGHT_BACK_MOTOR, DRIVE_MOTOR_TYPE);
  private MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightFrontDrive, m_rightBackDrive);

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
    m_leftFrontDrive.setInverted(!reverse);
    // m_leftBackDrive.setInverted(reverse);
    m_rightFrontDrive.setInverted(reverse);
    // m_rightBackDrive.setInverted(!reverse);

    m_leftBackDrive.follow(m_leftFrontDrive);
    m_rightBackDrive.follow(m_rightFrontDrive);

    // set current limits
    m_leftFrontDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_leftBackDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_rightFrontDrive.setSmartCurrentLimit(DRIVE_CURRENT);
    m_rightBackDrive.setSmartCurrentLimit(DRIVE_CURRENT);

    // Link:https://github.com/REVrobotics/SPARK-MAX-Examples/blob/master/Java/Soft%20Limits/src/main/java/frc/robot/Robot.java
    // soft limits
    m_leftFrontDrive.enableSoftLimit(SoftLimitDirection.kForward, true);
    m_leftFrontDrive.enableSoftLimit(SoftLimitDirection.kReverse, true);
    
    m_leftFrontDrive.setSoftLimit(SoftLimitDirection.kForward, 20);
    m_leftFrontDrive.setSoftLimit(SoftLimitDirection.kReverse, 10);
    
    // SmartDashboard.putBoolean("Left Front Forward Soft Limit Enabled",
    //                           m_leftFrontDrive.isSoftLimitEnabled(SoftLimitDirection.kForward));
    // SmartDashboard.putBoolean("Left Front Reverse Soft Limit Enabled",
    //                           m_leftFrontDrive.isSoftLimitEnabled(SoftLimitDirection.kReverse));                          
    // SmartDashboard.putNumber("Left Front Forward Soft Limit",
    //                           m_leftFrontDrive.getSoftLimit(SoftLimitDirection.kForward));
    // SmartDashboard.putNumber("Left Front Reverse Soft Limit",
    //                           m_leftFrontDrive.getSoftLimit(SoftLimitDirection.kReverse));

    m_roboDrive = new DifferentialDrive(m_leftFrontDrive, m_rightFrontDrive);
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    m_roboDrive.arcadeDrive(moveSpeed, rotateSpeed);
  }
  
  public void driveSet(double speed) {
    m_leftFrontDrive.set(speed);
  }

  public void middleLimit() {
    m_leftFrontDrive.setSoftLimit(SoftLimitDirection.kForward, 50);
    m_leftFrontDrive.setSoftLimit(SoftLimitDirection.kReverse, 0);
  }

  public void highLimit() {
    m_leftFrontDrive.setSoftLimit(SoftLimitDirection.kForward, 100);
    m_leftFrontDrive.setSoftLimit(SoftLimitDirection.kReverse, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
