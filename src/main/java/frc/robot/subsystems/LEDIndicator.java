// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import static frc.robot.Constants.OperatorConstants.LED_CHANNEL;

public class LEDIndicator extends SubsystemBase {
  private final AddressableLED indicator = new AddressableLED(LED_CHANNEL);
  /** Creates a new LEDIndicator. */
  public LEDIndicator() {
    indicator.setLength();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
