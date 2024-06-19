package com.nothing.howlong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/api/how-long")
public class HowLongRealTimeStreamingController {
	
	@Autowired
	MyMomentsStreamingBackgroundTask myMomentsStreamingBackgroundTask;
	
	
	
	
	
	/**
	 * HTTP Streaming
	 * SSE Emitter
	 * Server Sent Events
	 * @return
	 */
	@GetMapping(path="/streaming/moments/{dateTime}", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter handle(@PathVariable String dateTime) {
		
		SseEmitter emitter = new SseEmitter(86_400_000L); // streaming length
		
		try {
			
			System.out.println("The default timeout ::" + emitter.getTimeout());
			
			myMomentsStreamingBackgroundTask.setEmitter(emitter);
			myMomentsStreamingBackgroundTask.setMoment(dateTime);
			Thread streamingThread = new Thread(myMomentsStreamingBackgroundTask);
			streamingThread.start();
		} catch(Exception e) {
			
			System.err.println("INSIDE streaming exception : " +e);
			
		}
		

		return emitter;
	}
	
	

	

}
