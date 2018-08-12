package br.com.appservice.facade;

import org.springframework.stereotype.Component;

@Component("feedServiceFacadeImpl")
public class FeedServiceFacadeImpl implements FeedServiceFacade{

	@Override
	public String contentFeed() throws Exception {
		
		return "{\r\n" + 
				"   \"title\":\"Volkswagen Arteon aparece �s v�speras do Sal�o de Genebra\",\r\n" + 
				"   \"link\":\"http://revistaautoesporte.globo.com/Noticias/noticia/2017/03/volkswagen-arteon-aparece-vesperas-do-salao-de-genebra.html\",\r\n" + 
				"   \"content\":[\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"image\",\r\n" + 
				"         \"content\":\"http://s2.glbimg.com/DIgFxpN0aAu99uvuZ3WmSqAUV2E=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/1_WKIn5xh.jpg\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"text\",\r\n" + 
				"         \"content\":\"A Volkswagen revelou hoje (6) o Arteon, cup� de quatro portas escolhido para suceder o CC � antes chamado Passat CC � e que ser� apresentado ao p�blico durante o Sal�o de Genebra. O visual n�o chega a ser novidade, j� que � praticamente o mesmo h� dois anos, quando deu as caras no evento su��o como o prot�tipo Sport Coup� GTE Concept.\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"image\",\r\n" + 
				"         \"content\":\"http://s2.glbimg.com/NgWcluzNZLlXwCu9Vs8N1UHXGbI=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/2_aEXyzmK.jpg\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"text\",\r\n" + 
				"         \"content\":\"Para encarar o mundo real, a novidade recebeu ma�anetas nas portas, antena no teto e alguns detalhes exigidos por lei... e s�! At� mesmo as rodas gigantes, os para-choques agressivos e a grade do motor integrada aos far�is continuam ali � para a alegria dos f�s. Al�m do pacote esportivo R-Line, tamb�m haver� op��es um pouco mais conservadoras.\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"image\",\r\n" + 
				"         \"content\":\"http://s2.glbimg.com/lJKzhfcrbXSzQZRKXCcn7pEIRjw=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/3_BZIDgsI.jpg\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"text\",\r\n" + 
				"         \"content\":\"Se por fora tudo � diferente (e muito mais agressivo) comparado aos �irm�os�, o painel segue fiel ao estilo da marca � afinal, � o mesmo do Passat. N�o sabemos se a queda do teto compromete o espa�o para a cabe�a de quem vai atr�s, mas os 563 litros do porta-malas s�o bem aproveitados gra�as � tampa traseira que abre com o vidro, como um hatch.\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"image\",\r\n" + 
				"         \"content\":\"http://s2.glbimg.com/RJ9LxS8YaH4bCAlP1f_1Nm8cocY=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/4_vYYIbul.jpg\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"text\",\r\n" + 
				"         \"content\":\"A plataforma � a mesma MQB utilizada no Passat (que, gra�as ao milagre da modularidade, tamb�m serve ao Golf e, futuramente, � nova gera��o do Gol nacional). S�o 4,86 metros de comprimento; 1,87 m de largura; 1,42 m de altura; e 2,84 m de entre-eixos. Ainda que pare�a um latif�ndio, apenas quatro ocupantes viajam com conforto na cabine.\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"image\",\r\n" + 
				"         \"content\":\"http://s2.glbimg.com/EDuoev-xcbKnAK_QVWRclJa4Mac=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/5_71gviOe.jpg\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"text\",\r\n" + 
				"         \"content\":\"No Velho Continente, ser�o oferecidos motores a gasolina (1.5 turbo com 150 cv e 2.0 turbo nas op��es de 190 cv e 280 cv) e tamb�m a diesel (2.0 turbo nas op��es de 150 cv, 190 cv e 240 cv). Com exce��o das vers�es de entrada, que t�m c�mbio manual de seis marchas, a transmiss�o � sempre automatizada com dupla embreagem e sete marchas.\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"links\",\r\n" + 
				"         \"content\":[\r\n" + 
				"            \"http://revistaautoesporte.globo.com/Noticias/noticia/2016/01/os-12-mimos-mais-legais-do-volkswagen-passat.html\",\r\n" + 
				"            \"http://revistaautoesporte.globo.com/Analises/noticia/2015/11/avaliacao-novo-volkswagen-passat.html\"\r\n" + 
				"         ]\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"type\":\"image\",\r\n" + 
				"         \"content\":\"http://s2.glbimg.com/fkJMyLGJsX_ThzJBHalbemmcb4M=/620x413/e.glbimg.com/og/ed/f/original/2017/03/06/6_pih5QJE.jpg\"\r\n" + 
				"      }\r\n" + 
				"   ]\r\n" + 
				"}";
	}

}
