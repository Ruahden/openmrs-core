package org.openmrs.scheduler.db;

import java.util.List;

import org.openmrs.api.db.DAOException;
import org.openmrs.scheduler.Schedule;
import org.openmrs.scheduler.TaskConfig;

/**
 * Scheduler-related database methods.
 * 
 * @author Justin Miranda
 * @version 1.0
 */
public interface SchedulerDAO {

	/**
	 * Creates a new task.
	 * 
	 * @param task to be created
	 * @throws DAOException
	 */
	public void createTask(TaskConfig task) throws DAOException;

	/**
	 * Get task by internal identifier
	 * 
	 * @param taskId internal task identifier
	 * @return task with given internal identifier
	 * @throws DAOException
	 */
	public TaskConfig getTask(Integer taskId) throws DAOException;

	/**
	 * Update task 
	 * 
	 * @param task to be updated
	 * @throws DAOException
	 */
	public void updateTask(TaskConfig task) throws DAOException;

	/**
	 * Find all tasks with a given identifier
	 * 
	 * @param identifier
	 * @return set of tasks matching identifier
	 * @throws DAOException
	 */
	public List<TaskConfig> getTasks() throws DAOException;
	
	/**
	 * Delete task from database. 
	 * 
	 * @param task task to be deleted
	 * @throws DAOException
	 */
	public void deleteTask(TaskConfig task) throws DAOException;

	/**
	 * Delete task from database. 
	 * 
	 * @param taskId 	identifier of task to be deleted
	 * @throws DAOException
	 */
	public void deleteTask(Integer taskId) throws DAOException;

	/**
	 * Creates a new schedule.
	 * 
	 * @param schedule to be created
	 * @throws DAOException
	 */
	//public void createSchedule(Schedule schedule) throws DAOException;

	/**
	 * Get schedule by internal identifier
	 * 
	 * @param scheduleId internal schedule identifier
	 * @return schedule with given internal identifier
	 * @throws DAOException
	 */
	public Schedule getSchedule(Integer scheduleId) throws DAOException;

	/**
	 * Update a schedule.
	 * 
	 * @param schedule to be updated
	 * @throws DAOException
	 */
	//public void updateSchedule(Schedule schedule) throws DAOException;

	/**
	 * Get all schedules.
	 * 
	 * @return set of all schedules in the database
	 * @throws DAOException
	 */
	//public Set<Schedule> getSchedules() throws DAOException;
	
	/**
	 * Delete schedule from database. 
	 * 
	 * @param schedule schedule to be deleted
	 * @throws DAOException
	 */
	//public void deleteSchedule(Schedule schedule) throws DAOException;

}
