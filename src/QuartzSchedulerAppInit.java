import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import Jobs.QuartzJob;

public class QuartzSchedulerAppInit {
	private static Scheduler scheduler;

	public static void main(String[] args) throws SchedulerException, Exception {
		System.out.println("init");
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("Trigger", "simple_Group")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
		scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		JobDetail someJobDetail = JobBuilder.newJob(QuartzJob.class).withIdentity("Test", "simple_Group").build();
		scheduler.scheduleJob(someJobDetail, trigger);
		System.out.println("done");
		Thread.sleep(10 * 1000);
		scheduler.shutdown();
	}
}
