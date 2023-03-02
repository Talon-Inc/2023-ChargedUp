// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.subsystems.ExampleSubsystem;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  public static CommandBase testAuto(Drivetrain drivetrain, Pneumatics pneumatics, Arm arm, Sensor sensor) {
    sensor.pigeonIMU.getYawPitchRoll(sensor.ypr_deg);
    if (sensor.ypr_deg[2] < 5 || sensor.ypr_deg[2] > -5){
      return Commands.sequence(
        //new DriveDistance(2, 2, drivetrain),
        //new CloseClaw(pneumatics),
        new DriveDistance(-10.61, -10.61, drivetrain)
        // Left: +, Right: - = Forward
        // Left: -, Right: + = Backward
        // Left: +, Right: + = Turn Right
        // Left: -, Right - = Turn Left

        //new Middle(arm)
        //new OpenClaw(pneumatics)
      );}
    else {
      return Commands.sequence(
        new Balance(drivetrain, sensor)
      );}
    }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
