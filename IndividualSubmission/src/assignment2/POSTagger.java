package assignment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
 
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
 
public class POSTagger {
 
    public static void checkUserInput(String input) {
 
        InputStream tokenModelIn = null;
        InputStream posModelIn = null;
         
        try {
            // Tokenize the sentence
            tokenModelIn = new FileInputStream("./models/en-token.bin");
            
            TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
            
            Tokenizer tokenizer = new TokenizerME(tokenModel);
            
            String tokens[] = tokenizer.tokenize(input);
 
            // POS Tagging
            // reading POS model to the stream 
            posModelIn = new FileInputStream("./models/en-pos-maxent.bin");
            
            // loading the POS model from stream
            POSModel posModel = new POSModel(posModelIn);
            
            // POS tagger initialize
            POSTaggerME posTagger = new POSTaggerME(posModel);
            
        
            String tags[] = posTagger.tag(tokens);
            
            // Acquire probability of tokens
            double probs[] = posTagger.probs();
             
            
            /*
            NNP = Proper Noun, Singular
            VBZ = Verb, 3rd person singular present
            CD = Cardinal Number
            NNS = Noun, Plural
            JJ = Adjective
            */
            for(int i=0;i<tokens.length;i++){
                System.out.println(tokens[i]+"\t:\t"+tags[i]+"\t:\t"+probs[i]);
            }
            
             
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (tokenModelIn != null) {
                try {
                    tokenModelIn.close();
                }
                catch (IOException e) {
                }
            }
            if (posModelIn != null) {
                try {
                    posModelIn.close();
                }
                catch (IOException e) {
                }
            }
        }
    }
}