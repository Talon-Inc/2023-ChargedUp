// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final CANSparkMax m_leftFrontDrive = new CANSparkMax(DRIVE_LEFT_FRONT_MOTOR, MOTOR_TYPE);
  private final CANSparkMax m_leftBackDrive = new CANSparkMax(DRIVE_LEFT_BACK_MOTOR, MOTOR_TYPE);
  private final MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftFrontDrive, m_leftBackDrive);

  private final CANSparkMax m_rightFrontDrive = new CANSparkMax(DRIVE_RIGHT_FRONT_MOTOR, MOTOR_TYPE);
  private final CANSparkMax m_rightBackDrive = new CANSparkMax(DRIVE_RIGHT_BACK_MOTOR, MOTOR_TYPE);
  private final MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightFrontDrive, m_rightBackDrive);

  private DifferentialDrive m_roboDrive;
  private final Timer m_Timer = new Timer();

  /** Creates a new DriveTrain. */
  public DriveTrain() {

    m_leftFrontDrive.restoreFactoryDefaults();
    m_leftBackDrive.restoreFactoryDefaults();
    m_rightFrontDrive.restoreFactoryDefaults();
    m_rightBackDrive.restoreFactoryDefaults();

    // runs the motor at SPEED% power
    m_leftFrontDrive.set(SPEED); 
    m_leftBackDrive.set(SPEED);
    m_rightFrontDrive.set(SPEED);
    m_rightBackDrive.set(SPEED);

    // set left or right motors to be inverted/reversed
    boolean reverse = true;
    m_leftFrontDrive.setInverted(reverse);
    m_leftBackDrive.setInverted(reverse);
    m_rightFrontDrive.setInverted(!reverse);
    m_rightBackDrive.setInverted(!reverse);

    // m_leftBackDrive.follow(m_leftFrontDrive);
    // m_rightBackDrive.follow(m_rightFrontDrive);

    // set current limits
    m_leftFrontDrive.setSmartCurrentLimit(CURRENT);
    m_leftBackDrive.setSmartCurrentLimit(CURRENT);
    m_rightFrontDrive.setSmartCurrentLimit(CURRENT);
    m_rightBackDrive.setSmartCurrentLimit(CURRENT);

    // m_leftFrontDrive.setSecondaryCurrentLimit(CURRENT);
    // m_leftBackDrive.setSecondaryCurrentLimit(CURRENT);
    // m_rightFrontDrive.setSecondaryCurrentLimit(CURRENT);
    // m_rightBackDrive.setSecondaryCurrentLimit(CURRENT);

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

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase command1() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
