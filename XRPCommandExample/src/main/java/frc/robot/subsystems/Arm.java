// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {

  private final XRPServo arm = new XRPServo(4);
  /** Creates a new Arm. */
  public Arm() {}

  public void ArmSet180(){
    arm.setAngle(100);
  }

  public void ArmSet0 (){
    arm.setAngle(0);
  }

  public void moveWithLeftTrigger(double angle){
    arm.setAngle(angle);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


}
