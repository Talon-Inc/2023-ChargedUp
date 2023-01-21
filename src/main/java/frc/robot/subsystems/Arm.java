// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  public Arm() {
    public class Arm extends SubsystemBase {
      private Joystick m_stick;
      private static final int deviceID = 1;
      private CANSparkMax m_motor;
    }    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
