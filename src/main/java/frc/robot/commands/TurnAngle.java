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

public class TurnAngle extends Command {

public double m_previousError;
public double m_currentError;

public double m_previousTime;
public double m_CurrentTime;

public double m_outPut;

public double m_desiredAngle;

  public TurnAngle(double desiredAngle) {
    requires(Robot.m_drive);
    m_desiredAngle = desiredAngle;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   // Robot.Drive.resetGyro;
    m_previousTime = Timer.getFPGATimestamp();
    m_previousError = m_desiredAngle;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_CurrentTime = Timer.getFPGATimestamp();
   // m_currentError = m_previousError - Robot.m_drive.getangle;

    if(m_currentError > 180){
      m_currentError = m_currentError - 360;
    }

    if(m_currentError < -180){
      m_currentError = m_currentError + 360;
    }
    //m_derivative = (m_currentError - m_previousError) / (m_CurrentTime - m_previousTime);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
