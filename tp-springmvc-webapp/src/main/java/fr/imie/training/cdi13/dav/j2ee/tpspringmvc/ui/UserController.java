package fr.imie.training.cdi13.dav.j2ee.tpspringmvc.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.imie.training.cdi13.dav.appjee.bl.BusinessException;
import fr.imie.training.cdi13.dav.appjee.bl.ServiceFactory;
import fr.imie.training.cdi13.dav.appjee.bl.domain.User;
import fr.imie.training.cdi13.dav.appjee.bl.service.UserService;

@Controller
public class UserController {

	@RequestMapping("/user")
	public String all(ModelMap model) {

		List<User> userList = null;
		// List<UserDTO> userList = null;
		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userService = serviceFactory.getUserService();
			userList = userService.findUser();
			// final DAOFactory daoFactory = DAOFactory.getInstance();
			// final UserDAO userDAO = daoFactory.getUserDAO();
			// userList = userDAO.find();
		} catch (BusinessException e) {
			userList = new ArrayList<>();
		}

		model.addAttribute("userList", userList);
		return "user";
	}

	/*
	 * 
	 * private static final long serialVersionUID = 1L;
	 * 
	 * private final static String VIEW = "/WEB-INF/views/user.jsp";
	 * 
	 * 
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * final String urlConnection =
	 * "jdbc:postgresql://192.168.200.172:5432/fcpe";
	 * 
	 * // Datasource final Datasource ds = new JDBCDatasource();
	 * ds.init(urlConnection);
	 * 
	 * // DAL : construction des DAOs de l'application final Map<DAO.DAO_TYPE,
	 * DAO<?>> daoMap = new HashMap<>();
	 * 
	 * // BL : construction des Services de l'application final
	 * Map<Service.SERVICE_TYPE, Service<?>> serviceMap = new HashMap<>();
	 * 
	 * try { // DAL final DAO<?> dao =
	 * ApplicationFactory.getInstance().getDAO(DAO.DAO_TYPE.USER); dao.init(ds);
	 * daoMap.put(DAO.DAO_TYPE.USER, dao);
	 * 
	 * // BL : construction des Services de l'application Service<?> service =
	 * ApplicationFactory.getInstance().getService(Service.SERVICE_TYPE.USER);
	 * service.init(daoMap); serviceMap.put(Service.SERVICE_TYPE.USER, service);
	 * 
	 * } catch (ApplicationException e) {
	 * System.err.println("ApplicationException : " + e.getMessage()); }
	 * 
	 * final String uri = request.getRequestURI(); final UserService userSrv =
	 * (UserService) serviceMap.get(Service.SERVICE_TYPE.USER); List<UserDTO>
	 * userList = null; try {
	 * 
	 * // if (Pattern.matches("^./add$", uri)) {
	 * userSrv.create(this.convertToDTO(request));
	 * response.sendRedirect(request.getContextPath() + "/user"); } else if
	 * (Pattern.matches("^./del$", uri)) {
	 * userSrv.delete(this.convertToDTO(request));
	 * response.sendRedirect(request.getContextPath() + "/user"); } else if
	 * (Pattern.matches("^./upd$", uri)) {
	 * userSrv.update(this.convertToDTO(request));
	 * response.sendRedirect(request.getContextPath() + "/user"); } else {
	 * userList = userSrv.find(); request.setAttribute("userList", userList);
	 * request.getRequestDispatcher(VIEW).forward(request, response); }
	 * 
	 * } catch (ServiceException e) { System.err.println("ServiceException : " +
	 * e.getMessage()); }
	 * 
	 * 
	 * } protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { doGet(request,
	 * response); }
	 * 
	 * private UserDTO convertToDTO(HttpServletRequest request) { UserDTO dto =
	 * new UserDTO(); String sId = request.getParameter("user.id"); if (sId !=
	 * null) { dto.setId(Integer.parseInt(sId)); }
	 * dto.setConnectionId(request.getParameter("user.login"));
	 * dto.setNom(request.getParameter("user.nom"));
	 * dto.setPrenom(request.getParameter("user.prenom"));
	 * dto.setEmail(request.getParameter("user.email"));
	 * dto.setPassword(request.getParameter("user.password"));
	 * 
	 * String sActif = request.getParameter("user.actif"); boolean actif =
	 * false; if ("1".equals(sActif) || "on".equals(sActif)){ actif = true; }
	 * dto.setActif(Boolean.valueOf(actif));
	 * 
	 * return dto; }
	 * 
	 */

}
