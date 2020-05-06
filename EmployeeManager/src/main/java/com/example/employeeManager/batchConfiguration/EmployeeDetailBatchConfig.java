package com.example.employeeManager.batchConfiguration;



import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.employeeManager.entity.EmployeeDetail;
import com.example.employeeManager.listner.JobCompletionNotificationListener;

@Configuration
@EnableBatchProcessing
@EnableScheduling
//@Log4j2
public class EmployeeDetailBatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Value("${spring.batch.job.path}")
	private Resource resource;

	@Value("${spring.batch.job.names}")
	private String loadLotDetailsJob;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@Bean
	public FlatFileItemReader<EmployeeDetail> reader() {

		FlatFileItemReader<EmployeeDetail> menuItemReader = new FlatFileItemReaderBuilder<EmployeeDetail>().name("menuItemReader")
				.resource(new ClassPathResource("EMPLOYEE_DETAILS.csv")).delimited()
				.names(new String[] { "eId","ename", "email", "phoneNumber", "designation", "experience","lotid","status" }).targetType(EmployeeDetail.class)
				.linesToSkip(1).build();

		return menuItemReader;
	}
	

	@Bean
	public JpaItemWriter<EmployeeDetail> writer() {
		JpaItemWriter<EmployeeDetail> jpaItemWriter = new JpaItemWriter<>();
		jpaItemWriter.setEntityManagerFactory(entityManagerFactory);
		return jpaItemWriter;
	}

	@Bean
	public JobCompletionNotificationListener listener() {
		return new JobCompletionNotificationListener();
	}

	@Bean
	public Job updateMenuItemsJob(Step step1) {
		return jobBuilderFactory.get(loadLotDetailsJob).incrementer(new RunIdIncrementer()).listener(listener())
				.flow(step1).end().build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<EmployeeDetail, EmployeeDetail>chunk(2).reader(reader()).writer(writer()).build();
	}

//	@Scheduled(cron = "0 0 1 * * MON-FRI")
//	@Scheduled(fixedDelay = 300000)
	public void doJob() {
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("jobId", String.valueOf(System.currentTimeMillis())).addString("jobName", loadLotDetailsJob)
				.toJobParameters();
		try {
			jobLauncher.run(job, jobParameters);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
//			log.error(e.getMessage());
		}
	}

}
