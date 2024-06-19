package com.nothing.howlong;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MyMomentsStreamingBackgroundTask implements Runnable {

	
	private ResponseBodyEmitter emitter;
	
	
	private Object moment;
	
	
	
	
	
	
	@Override
	public void run() {
		String howLong=null;
		while (true) {

			try {

				System.out.println("@@ the moment"+moment);
				
				 howLong = MyDateUtils.parsePostDuration(MyDateUtils.periodNow(String.valueOf(moment)));

				
				emitter.send(howLong);
				
				Thread.sleep(60000);
				
				

				
			} catch (Exception e) {
					
				System.err.println("Task exception " + e);
			} 

		}
	}
}
