package br.com.appservice.rest;

import java.io.Writer;

import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import br.com.appservice.facade.UsuarioServiceFacade;
import br.com.appservice.model.User;

@Component("usuarioRest")
@Service("usuarioRest")
public class UsuarioRest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRest.class);
	
	@Autowired
	private UsuarioServiceFacade facade;
	
	/**
	 * METODO UTILIZADO PARA CADASTRAR O USUARIO
	 * @param nome
	 * @param sobrenome
	 * @param cpf
	 * @return jSON USER
	 */
	@POST
	@Path("/inserirUsuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response inserirUsuario(@QueryParam("nome")String nome,@QueryParam("sobrenome")String sobrenome,@QueryParam("cpf")String cpf) {
		XStream xStream = new XStream(new JsonHierarchicalStreamDriver(){
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		xStream.setMode(XStream.NO_REFERENCES);
		String msg = null;
		String json = null;
		String excessao = null;
		User user =  new User();
		try {
			
			if ("".equals(nome)) {
				msg = "preencha o nome.";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			
			if ("".equals(sobrenome)) {
				msg = "preencha o password.";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			if ("".equals(cpf)) {
				msg = "preencha o cpf.";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			
			user.setNome(nome);
			user.setSobrenome(sobrenome);
			user.setCpf(cpf);
			user.setSucesso(" Usuário inserido com sucesso! ");
			this.facade.inserirUsuario(user);
			user.setHttpStatus(Response.status(Status.OK).entity(json)
					.type(MediaType.APPLICATION_JSON).build().getStatus());
			
			
			
		} catch (Exception e) {
			LOGGER.error(" Erro ao cadastrar o usuario "
					+ e.getMessage());
			excessao = " Erro ao cadastrar o usuario ";
			user.setExcessao(excessao);
			user.setHttpStatus(Response.status(Status.INTERNAL_SERVER_ERROR).entity(json)
					.type(MediaType.APPLICATION_JSON).build().getStatus());
			xStream.alias("usuarioAndroid", User.class);
			json = xStream.toXML(user);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(json).type(MediaType.APPLICATION_JSON).build();
		}
		
		return Response.status(Status.OK).entity(user).type(MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * METODO RECUPERA O USUARIO PELO ID DO OBJETO
	 * @param idUsuario
	 * @return jSON USER
	 */
	@GET
	@Path("/findByIdUsuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(@QueryParam("idUsuario")String idUsuario) {
		XStream xStream = new XStream(new JsonHierarchicalStreamDriver(){
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		xStream.setMode(XStream.NO_REFERENCES);
		String msg = null;
		String json = null;
		String excessao = null;
		User user = new User();
		try {
			
			if("".equals(idUsuario)){
				msg = " idUsuario obrigatório. ";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			
			user = this.facade.findById(Long.valueOf(idUsuario));
			user.setHttpStatus(Response.status(Status.OK).entity(json)
					.type(MediaType.APPLICATION_JSON).build().getStatus());
			
			
		}  catch (Exception e) {
			LOGGER.error(" Erro ao recuperar o usuario "
					+ e.getMessage());
			excessao = " Erro ao recuperar o usuario ";
			user.setExcessao(excessao);
			user.setHttpStatus(Response.status(Status.INTERNAL_SERVER_ERROR).entity(json)
					.type(MediaType.APPLICATION_JSON).build().getStatus());
			xStream.alias("usuario",User.class);
			json = xStream.toXML(user);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(json)
					.type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.OK).entity(user).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	/**
	 * ATUALIZA O USUARIO CADASTRADO
	 * @param idUsuario
	 * @param nome
	 * @param sobrenome
	 * @param cpf
	 * @return JSON USER
	 */
	@PUT
	@Path("/UpdateUsuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response UpdateUsuario(@QueryParam("idUsuario")String idUsuario,@QueryParam("nome")String nome,@QueryParam("sobrenome")String sobrenome,@QueryParam("cpf")String cpf) {
		XStream xStream = new XStream(new JsonHierarchicalStreamDriver(){
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		xStream.setMode(XStream.NO_REFERENCES);
		String msg = null;
		String json = null;
		String excessao = null;
		User user = new User();
		try {
			if ("".equals(idUsuario)) {
				msg = "preencha o idUsuario.";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			
			if ("".equals(nome)) {
				msg = "preencha o nome.";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			
			if ("".equals(sobrenome)) {
				msg = "preencha o password.";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			
			if ("".equals(cpf)) {
				msg = "cpf o password.";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			
			
			user.setId(Long.valueOf(idUsuario));
			user.setNome(nome);
			user.setSobrenome(sobrenome);
			user.setCpf(cpf);
			user.setSucesso(" Usuário atualizado com sucesso! ");
			user.setHttpStatus(Response.status(Status.OK).entity(json)
					.type(MediaType.APPLICATION_JSON).build().getStatus());
			
			this.facade.upadateUsuario(user);
			
		} catch (Exception e) {
			LOGGER.error(" Erro ao atualizar ou usuario inexistente! "
					+ e.getMessage());
			excessao = " Erro ao atualizar ou usuario inexistente! ";
			user.setExcessao(excessao);
			user.setError(" Erro ao atualizar ou usuario inexistente! ");
			user.setHttpStatus(Response.status(Status.INTERNAL_SERVER_ERROR).entity(json)
					.type(MediaType.APPLICATION_JSON).build().getStatus());
			xStream.alias("usuario",User.class);
			json = xStream.toXML(user);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(json)
					.type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Status.OK).entity(user).type(MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * METODO DE DELECAO DO USUARIO
	 * @param idUsuario
	 * @return JSON MESSAGE
	 */
	@DELETE
	@Path("/deleteUsuario")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteUsuario(@QueryParam("idUsuario") String idUsuario) {
		XStream xStream = new XStream(new JsonHierarchicalStreamDriver(){
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		xStream.setMode(XStream.NO_REFERENCES);
		String msg = null;
		String json = null;
		String excessao = null;
		User user = new User();
		try {
			if("".equals(idUsuario)){
				msg = " idUsuario obrigatório. ";
				xStream.alias("usuario", User.class);
				user.setError(msg);
				user.setHttpStatus(Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build().getStatus());
				json = xStream.toXML(user);
				return Response.status(Status.NOT_FOUND).entity(json)
						.type(MediaType.APPLICATION_JSON).build();
			}
			
			this.facade.deleteUsuario(Long.valueOf(idUsuario));
			
			user.setSucesso(" Usuário foi deletado com suceso! ");
			user.setHttpStatus(Response.status(Status.OK).entity(json)
					.type(MediaType.APPLICATION_JSON).build().getStatus());

		} catch (Exception e) {
			LOGGER.error(" Erro ao deletar o usuario "
					+ e.getMessage());
			excessao = " Erro ao deletar o usuario ";
			user.setExcessao(excessao);
			user.setHttpStatus(Response.status(Status.INTERNAL_SERVER_ERROR).entity(json)
					.type(MediaType.APPLICATION_JSON).build().getStatus());
			xStream.alias("usuario",User.class);
			json = xStream.toXML(user);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(json)
					.type(MediaType.APPLICATION_JSON).build();

		}
		return Response.status(Status.OK).entity(user).type(MediaType.APPLICATION_JSON).build();
		
	}
	

	@WebMethod(exclude=true)
	public void setFacade(UsuarioServiceFacade facade) {
		this.facade = facade;
	}
	
}
