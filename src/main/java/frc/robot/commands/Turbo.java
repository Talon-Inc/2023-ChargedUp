// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Turbo extends CommandBase {
  private Drivetrain drivetrain = null;

  /** 
   * Creates a new Turbo command.
   * 
   * @param drivetrain Gets the Drivetrain subsystem
   */
  public Turbo(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    // addRequirements(driveTrain); // not added for some reason
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.turbo();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.unturbo();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
