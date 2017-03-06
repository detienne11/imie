package fr.imie.training.cdi13.dav.tpjpa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.domain.BO.STATE;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Eleve;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Parent;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Person;
import fr.imie.training.cdi13.dav.appjee.bl.domain.Person.PERSON_TYPE;
import fr.imie.training.cdi13.dav.appjee.bl.service.PersonServiceEjb;

/**
 * Servlet implementation class JPAServlet
 */
@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private PersonServiceEjb personService;

	private final static String JSP_VIEW = "/WEB-INF/views/person.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String uri = request.getRequestURI();
		final String mainUri = request.getContextPath() + "/person";

		List<Person> personList = null;
		try {

			Pattern pattern = Pattern.compile("^.*/(add|del|upd)/(.*)$");
			Matcher matcher = pattern.matcher(uri);
			if (matcher.matches()) {

				Person person = this.convertToEntity(request);

				String action = matcher.group(1);
				// String version = matcher.group(2);
				if ("add".equals(action)) {
					person.setState(STATE.TO_INSERT);
				} else if ("del".equals(action)) {
					person.setState(STATE.TO_REMOVE);
				} else if ("upd".equals(action)) {
					
					if (request.getParameter("person.delete") != null){
						person.setState(STATE.TO_REMOVE);
					}
					else {
						person.setState(STATE.TO_UPDATE);
					}
				}

				personService.persist(person);

				response.sendRedirect(mainUri);

			} else {

				personList = personService.find();

				request.setAttribute("personList", personList);
				request.getRequestDispatcher(JSP_VIEW).forward(request, response);
			}

		} catch (BusinessException e) {
			personList = new ArrayList<>();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private Person convertToEntity(HttpServletRequest request) {

		final String type = request.getParameter("person.type");
		final String sId = request.getParameter("person.id");
		final String nom = request.getParameter("person.nom");
		final String prenom = request.getParameter("person.prenom");
		final String email = request.getParameter("person.email");
		final String nomClasse = request.getParameter("person.nomClasse");

		Person bo = null;

		if ("2".equals(type)) {
			// Parent
			bo = new Parent();
			bo.setType(PERSON_TYPE.PARENT);
			Parent p = ((Parent) bo);
			p.setEmail(email);
		} else if ("3".equals(type)) {
			// Eleve
			bo = new Eleve();
			bo.setType(PERSON_TYPE.ELEVE);
			Eleve e = ((Eleve) bo);
			e.setNomClasse(nomClasse);
		} else {
			// Person
			bo = new Person();
			bo.setType(PERSON_TYPE.PERSON);
		}

		if (sId != null) {
			bo.setId(Integer.parseInt(sId));
		}

		bo.setNom(nom);
		bo.setPrenom(prenom);

		return bo;
	}

}
