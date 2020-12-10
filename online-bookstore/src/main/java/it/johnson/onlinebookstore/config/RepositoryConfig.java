package it.johnson.onlinebookstore.config;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import it.johnson.onlinebookstore.entities.Book;
import it.johnson.onlinebookstore.entities.BookCategory;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
	@Autowired
	private EntityManager entityManager;// help to expose the hidden field like id on the browser
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		//config.exposeIdsFor(Book.class);// rende l'id visibile nel browser
		//config.exposeIdsFor(BookCategory.class);
		
		//uso dell'oggetto entityManager peer prendere tutte le entità, poi uso il metodo stream, javaType, poi lo metto dentro un array
		config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));
	}

}
