// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  private final PWMSparkMax m_leftfrontDrive = new PWMSparkMax(DRIVE_LEFT_FRONT_MOTOR);
  private final PWMSparkMax m_leftrearDrive = new PWMSparkMax(DRIVE_LEFT_BACK_MOTOR);
  private final MotorControllerGroup m_leftDrive = new MotorControllerGroup(m_leftfrontDrive, m_leftrearDrive);

  private final PWMSparkMax m_rightfrontDrive = new PWMSparkMax(DRIVE_RIGHT_FRONT_MOTOR);
  private final PWMSparkMax m_rightrearDrive = new PWMSparkMax(DRIVE_RIGHT_BACK_MOTOR);
  private final MotorControllerGroup m_rightDrive = new MotorControllerGroup(m_rightfrontDrive, m_rightrearDrive);

  private final DifferentialDrive m_RoboDrive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  private final Timer m_Timer = new Timer();
  
  /** Creates a new DriveTrain. */
  public DriveTrain() {

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
