package assignment2;

import java.util.Properties;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class PersonFinder {
private String name;
private String sentence;

public String getName() {
	return name;
}
public String getSentence() {
	return sentence;
}

//if a person is idenified in a sentence the name will be saved to name
//and a sanitized sentence will be created where the person enity will be replaced with "person"
// only works for one name.
public boolean findPerson(String input){
	Properties props = new Properties();
	props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
	StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	CoreDocument doc = new CoreDocument(input);
	 pipeline.annotate(doc);
	 try {
		 for (CoreEntityMention em : doc.entityMentions()) {
			 if(em.entityType().equals("PERSON")) {
			 name = em.text();
			 sentence = replaceNameWithPerson(input, false);
			 return true;
			 }
		     
		 }
	 }catch(Exception ex) {
		 
	 }
	 
	return false;
}

// proper output found replace all "person" with correct name if putNameIn true
// if put in Name is false replace name with "person"
public String replaceNameWithPerson(String input, boolean putNameIn) {
	String[] words = input.split("\\s+");
	String output = "";
	if(putNameIn) {
		for(String word: words) {
			if(word.equals("person")) {
				output += " " + name;
			}else
				output += " " +word;
		}
	}else {
		for(String word: words) {
			if(word.equals(name)) {
				output += " person";
			}else
				output += " " + word;
		}
	}
	return output;
}


}
