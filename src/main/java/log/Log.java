package log;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;



public class Log{

	private final static Logger log = (Logger) LoggerFactory.getLogger(Log.class);
	 
	 public static void info(String s){
		 log.info(s);
	 }
	 
	 public static void dubug(String s){
		 log.info(s);
	 }
	 
	 public static void error(String s){
		 log.info(s);
	 }
	 
	 public static void wran(String s){
		 log.info(s);
	 } 
}
