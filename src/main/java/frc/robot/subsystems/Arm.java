// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.OperatorConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.SoftLimitDirection;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Arm extends SubsystemBase {
  private final Joystick m_Joystick = new Joystick(CONTROLLER_PORT);
  private final CANSparkMax m_armMotor = new CANSparkMax(ARM_MOTOR, ARM_MOTOR_TYPE);

  /** Creates a new Arm. */
  public Arm() {
    m_armMotor.restoreFactoryDefaults();
    // m_armMotor.setInverted(true);

    // Arm limits 
    // m_armDrive.setSmartCurrentLimit(60);

    // Arm idle behavior
    // m_armDrive.setIdleMode(IDLE);

    // enable soft limits
    m_armMotor.enableSoftLimit(SoftLimitDirection.kForward, true);
    m_armMotor.enableSoftLimit(SoftLimitDirection.kReverse, true);

    m_armMotor.setSoftLimit(SoftLimitDirection.kForward, 20);
    m_armMotor.setSoftLimit(SoftLimitDirection.kReverse, 0);

    
  }

  public void middleExtend() {
    Timer timer = new Timer();
    timer.start();
    while (timer.hasElapsed(5)) {
      m_armMotor.set(.5);
    }
  }

  public void extend() {
    m_armMotor.set(.5);
  }

  public void retract() {
    m_armMotor.set(-.5);
  }

  public void highExtend() {
    Timer timer = new Timer();
    timer.start();
    while (timer.hasElapsed(9)) {
      m_armMotor.set(.5);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run  
  }
}
