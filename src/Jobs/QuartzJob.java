package Jobs;

import java.time.LocalDateTime;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import BusinessTask.MyTask;

public class QuartzJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		LocalDateTime localTime = LocalDateTime.now();
		System.out.println("Run QuartzJob at " + localTime.toString());
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		// MyTask mytask = new MyTask();
		// mytask.perform();
	}

}
