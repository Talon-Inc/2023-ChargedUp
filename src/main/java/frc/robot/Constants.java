// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {    
    
    // Drive motors
    public static final int DRIVE_LEFT_FRONT_MOTOR = 2;
    public static final int DRIVE_LEFT_BACK_MOTOR = 4;
    public static final int DRIVE_RIGHT_FRONT_MOTOR = 1;
    public static final int DRIVE_RIGHT_BACK_MOTOR = 3;
    public static final MotorType DRIVE_MOTOR_TYPE = MotorType.kBrushless;
    public static final double SPEED = .5;
    public static final IdleMode DRIVE_IDLE_TYPE = IdleMode.kBrake;
    public static final int DRIVE_CURRENT = 30;
    public static double DRIVE_FACTOR = .5; // changed for turbo

    // Arm motors
    public static final int ARM_MOTOR = 5;
    public static final MotorType ARM_MOTOR_TYPE = MotorType.kBrushless;

    // Pnuematics
    public static final int FORWARD_CHANNEL = 0;
    public static final int REVERSE_CHANNEL = 1;
    public static final PneumaticsModuleType PNEUMATICS_MODULE_TYPE = PneumaticsModuleType.valueOf("REVPH");

    // Sensor things
    public static final int TALON_CHANNEL = 8;

    // Controller inputs
    public static final int CONTROLLER_PORT = 0;
    public static final int LEFT_STICK_X = 0;
    public static final int LEFT_STICK_Y = 1;
    public static final double LEFT_TRIGGER = 2;
    public static final double RIGHT_TRIGGER = 3;
    public static final double RIGHT_STICK_X = 4;
    public static final double RIGHT_STICK_Y = 5;

    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int BACK_BUTTON = 7;
    public static final int START_BUTTON = 8;
    public static final int LEFT_STICK_BUTTON = 9;
    public static final int RIGHT_STICK_BUTTON = 10;
  }
}
