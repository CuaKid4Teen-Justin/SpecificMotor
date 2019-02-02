/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants.constants;

public class TurnDegrees extends Command {

// Thanks, Marcos

  public double m_output;
  public double m_desiredDistance;
  public double m_currentError;

  public double m_derivative;
  public double m_oldTime;
  public double m_currentTime;
  public double m_oldError;

  //error = desired - actual distance
  //m_output 
  // drive subsystem does GetPosition
  //figure set power to motor^^
  // kP  = constant YOU trial and error tune

  public TurnDegrees(double distance) {
    m_desiredDistance = distance; 
  requires(Robot.m_drive);

    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_oldTime = Timer.getFPGATimestamp();
    m_oldError= m_desiredDistance;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_currentTime = Timer.getFPGATimestamp();
// used for more precise calculations
    m_currentError = m_desiredDistance - Robot.m_drive.Position();
// ^^ tells how much further the Robot goes
    m_derivative = (m_currentError - m_oldError) / (m_currentTime - m_oldTime);
// ^^ PID formula stuff. The change of error / change of time to be more precise
    m_output = m_currentError * constants.kP + constants.kD * m_derivative;
// tells how much power the motor will change
    Robot.m_drive.SetPower(m_output);
// changes motor power

    m_oldError = m_currentError;
// how error distance updates so it won't repeat old mistake
    m_oldTime = m_currentTime;
// same as line above
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(m_currentError) <= constants.tolerance;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drive.SetPower(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
