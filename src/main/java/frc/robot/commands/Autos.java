// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;

public final class Autos {
  /** Example static factory for an autonomous command. */
  public static CommandBase exampleAuto(ExampleSubsystem subsystem) {
    return Commands.sequence(subsystem.exampleMethodCommand(), new ExampleCommand(subsystem));
  }

  public static CommandBase driveStraight(Drivetrain drivetrain) {
    return null;
  }

  public static CommandBase leftSideAuto(Drivetrain drivetrain) {
    return Commands.sequence(new DriveDistance(-40, 10, drivetrain)); // temp numbers
  }

  public static CommandBase centerAuto(Drivetrain drivetrain) {
    return Commands.sequence(new DriveDistance(-40, -40, drivetrain)); // temp numbers
  }

  public static CommandBase rightSideAuto(Drivetrain drivetrain) {
    return Commands.sequence(new DriveDistance(10, -40, drivetrain)); // temp numbers
  }

  public static CommandBase limelightAuto(Drivetrain drivetrain, double aprilTagID) {
    if (aprilTagID == 1){
      return Commands.sequence(

      );
    }
    else if (aprilTagID == 3){
      return Commands.sequence(


      );
    }
    else if (aprilTagID == 5){
      return Commands.sequence(


      );
    }
    else if (aprilTagID == 7){
      return Commands.sequence(
    
    
      );
    }
    else if (aprilTagID == 8){
      return Commands.sequence(


      );
    }
    else {
      return Commands.sequence(
        new DriveDistance(50, 50, drivetrain),
        new DriveDistance(-50, 50, drivetrain)
      );
    }
    //return Commands.sequence(
      //new DriveDistance(50, 50, drivetrain),
      //new DriveDistance(-50, 50, drivetrain)
    //);
  }

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
