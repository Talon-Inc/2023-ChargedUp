// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.OperatorConstants.DRIVE_FACTOR;
import static frc.robot.Constants.OperatorConstants.DRIVE_REVERSE;
import static frc.robot.Constants.OperatorConstants.TURN_FACTOR;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
  private Drivetrain drivetrain = null;
  private double mvSpeed = 0;
  private double rtSpeed = 0;
  //private double mvSpeed = 0, rtSpeed = 0;
  /** 
   * Creates a new Drive command.
   * 
   * @param drivetrain Gets Drivetrain subsystem; Arcade drive based drivetrain
   * @param mvSpeed Move speed: Left stick Y axis
   * @param rtSpeed Rotate speed: Left stick X axis
   */
  public Drive(Drivetrain drivetrain, double mvSpeed, double rtSpeed) {
    this.drivetrain = drivetrain;
    this.mvSpeed = mvSpeed;
    this.rtSpeed = rtSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double moveSpeed = DRIVE_REVERSE * DRIVE_FACTOR * -mvSpeed;
    double rotateSpeed = TURN_FACTOR * -rtSpeed;
    drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
