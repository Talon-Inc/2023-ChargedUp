// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;

public class AutoRetract extends CommandBase {
  private Arm arm = null;
  private boolean flag = false;
  private Timer timer = null;

  /** Creates a new AutoRetract. */
  public AutoRetract(Arm arm) {
    this.arm = arm;
    timer = new Timer();
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.retract();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (timer.hasElapsed(3) && (arm.output() == 0)) {
      end(true);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stop();
    flag = true;
    System.out.println("Ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (flag) {
      return true;
    }
    return false;
  }
}
