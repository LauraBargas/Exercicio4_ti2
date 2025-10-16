package ex_04;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.core.credential.AzureKeyCredential;

public class Analisesent {

	private static final String CHAVE_DO_SERVICO = "";
    private static final String PONTO_DE_EXTREMIDADE = "https://textsentimental.cognitiveservices.azure.com/";

    public static void main(String[] args) {
    
      
        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
                .endpoint(PONTO_DE_EXTREMIDADE)
                .credential(new AzureKeyCredential(CHAVE_DO_SERVICO))
                .buildClient();

        
        String texto = "Não estou feliz com o resultado!";
        
        System.out.println("Analisando a frase: '" + texto + "'");  
 
     
        DocumentSentiment resultado = client.analyzeSentiment(texto); 
        
        
        System.out.println("----------------------------------------");
        
       
        System.out.println("Sentimento Geral Detectado: " + resultado.getSentiment());
        
        System.out.println("Pontuação de Confiança:");
        
       
        System.out.printf("  Positivo: %.2f%n", resultado.getConfidenceScores().getPositive());
        System.out.printf("  Neutro:   %.2f%n", resultado.getConfidenceScores().getNeutral());
        System.out.printf("  Negativo: %.2f%n", resultado.getConfidenceScores().getNegative());
        
        System.out.println("----------------------------------------");
    }
}
