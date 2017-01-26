package fr.imie.training.cdi13.dav.jdbc.app;

public interface Application {

	public void init() throws ApplicationException;

	public void start() throws ApplicationException;

	public void stop() throws ApplicationException;

	public String getNom();

}
