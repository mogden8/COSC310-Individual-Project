package assignment2;



import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;

public class TranslateTxt
{
    public static String translateText(String reply, String targetLang) throws IOException, GeneralSecurityException
    {
        Translate t = new Translate.Builder(
                GoogleNetHttpTransport.newTrustedTransport()
                , GsonFactory.getDefaultInstance(), null)
                .setApplicationName("TranslateAPI")
                .build();
        Translate.Translations.List list = t.new Translations().list(
                Arrays.asList(reply),targetLang);

        String transText="";
        list.setKey("AIzaSyCQEsTS2gmruIxLuDPGHDhIPbaExQnfcTM");
        TranslationsListResponse response = list.execute();
        for (TranslationsResource translationsResource : response.getTranslations())
        {
            transText=translationsResource.getTranslatedText();
        }
        return transText;
    }
}