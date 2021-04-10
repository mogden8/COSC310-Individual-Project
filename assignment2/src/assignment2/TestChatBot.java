package assignment2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestChatBot {
	
	static ChatBot bot;
	static SentimentAnalyzer sentiment;
	static PersonFinder pf;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bot = new ChatBot();
		sentiment = new SentimentAnalyzer();
		pf = new PersonFinder();
	}

	@Test
	public void testAnalyzeSentiment() {
		assertTrue(sentiment.analyze("You are quite useful") >= 2);
		assertTrue(sentiment.analyze("I love you!") >= 2);
		assertTrue(sentiment.analyze("Not sure about that..") == 2);
		assertTrue(sentiment.analyze("I hate you!!") <= 2);
		assertTrue(sentiment.analyze("You make me sick.") <= 2);
	}
	
	@Test
	public void testStemInput() {
		assertEquals("train", bot.stemInput("training").trim());
		assertEquals("gym", bot.stemInput("gyms").trim());
		assertEquals("time", bot.stemInput("timing").trim());
	}
	
	@Test
	public void testNotUnderstood() {
		String[] responses ={
    			"Sorry, I didn't quite get that",
    			"Sorry, I'm a little confused. Try again?",
    			"I did not understand your query",
    			"My apologies, I am not sure what you are trying to ask",
    			"I don't recognize what you are trying to ask"
    			};
		
		boolean success = false;
		String actual = bot.notUnderstood();
		for(String exp : responses)
			if(exp.equals(actual))
				success = true;
		
		assertTrue(success);
	}
	
	@Test
	public void testFindPerson() {
		pf.findPerson("Hey, where can I find John?");
		assertEquals("John", pf.getName());
		pf.findPerson("Is Jill around?");
		assertEquals("Jill", pf.getName());
	}

}
