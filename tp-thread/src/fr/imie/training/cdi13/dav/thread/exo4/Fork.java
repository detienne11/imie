package fr.imie.training.cdi13.dav.thread.exo4;

public class Fork {

	private long id;

	private boolean free;

	public Fork(long id) {
		super();
		this.id = id;
		this.free = true;
	}

	public boolean isFree() {
		return this.free;
	}

	public void setFree() {
		this.free = true;
	}
	
	public void using() {
		this.free = false;
	}

	@Override
	public String toString() {
		return "Fork " + id + "[free=" + free + "]";
	}

}
