package br.com.appservice.rest;

import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.appservice.facade.FeedServiceFacade;
import br.com.appservice.facade.UsuarioServiceFacade;
import br.com.appservice.model.User;

@Component("feedRest")
@Service("feedRest")
public class FeedRest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedRest.class);
	
	@Autowired
	private FeedServiceFacade feedServiceFacade;
	
	@Autowired
	private UsuarioServiceFacade usuarioServiceFacade;
	
	/**
	 * Metodo utilizado para recuperar o feed
	 * @param nome
	 * @param cpf
	 * @return String
	 */
	@GET
	@Path("/feedInfoGlobo")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response feedInfoGlobo(@QueryParam("nome")String nome,@QueryParam("cpf")String cpf) {
		String json = null;
		User user = new User();
		
		try {
			//VALIDANDO O NOME DO USUARIO
			if("".equals(nome)) {
				return Response.status(Status.NOT_FOUND).entity(" Nome obrigatorio ").type(MediaType.APPLICATION_JSON).build();
			}
			
			//VALIDANDO O CPF DO USUARIO
			if("".equals(cpf)) {
				return Response.status(Status.NOT_FOUND).entity(" CPF obrigatorio ").type(MediaType.APPLICATION_JSON).build();
			}
			
			//AUTANTICANDO NA BASE DE DADOS 
			user = this.usuarioServiceFacade.findNomeAndCpf(nome, cpf);
		
			//VERIFICANDO SE O USUARIO E EXISTENTE
			if (user == null) {
				return Response.status(Status.NOT_FOUND).entity(" Usuario nao encontrado! ")
						.type(MediaType.APPLICATION_JSON).build();
			}
			
		//RECUPERANDO O JSON FEED DO DESAFIO EXTRA	
		json = this.feedServiceFacade.contentFeed();
			
		} catch (Exception e) {
			LOGGER.error(" Erro ao cadastrar o usuario "
					+ e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
		}
		
		//RETORNADO O JSON
		return Response.status(Status.OK).entity(json).type(MediaType.APPLICATION_JSON).build();
	}

	@WebMethod(exclude=true)
	public void setFeedServiceFacade(FeedServiceFacade feedServiceFacade) {
		this.feedServiceFacade = feedServiceFacade;
	}

	@WebMethod(exclude=true)
	public void setUsuarioServiceFacade(UsuarioServiceFacade usuarioServiceFacade) {
		this.usuarioServiceFacade = usuarioServiceFacade;
	}

}
