// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
// (Arm motor import goes here) 

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  public Arm() {
    final Joystick m_Joystick; 

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // set arm motor to be inverted/reversed
    boolean reverse = true;
    /** arm_motor */.setInverted(reverse);

    // Arm limits 

    /** arm_motor */.setSmartCurrentLimit(CURRENT);

    // Arm idle behavior

    /** arm_motor */.setIdleMode(IDLE);
  
    m_roboDrive = new DifferentialDrive(/** arm motor */);

  }
}
