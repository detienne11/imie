package fr.imie.cdi13.training.jdbc.dav;

public interface Application {

	public void init() throws ApplicationException;

	public void start() throws ApplicationException;

	public void stop() throws ApplicationException;

	public String getNom();

}
