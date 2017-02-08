package fr.imie.training.cdi13.dav.tpj2ee.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SommeTag extends SimpleTagSupport {

	private Integer param1;
	
	private Integer param2;
	
	
	public void setParam1(Integer param1) {
		this.param1 = param1;
	}



	public void setParam2(Integer param2) {
		this.param2 = param2;
	}



	@Override
	public void doTag() throws JspException, IOException {
		int somme = 0;
		if (this.param1 != null){
			somme = this.param1.intValue();
		}
		if (this.param2 != null){
			somme += this.param2.intValue();
		}
		
		getJspContext().getOut().print("Somme : " + String.valueOf(somme));
	}

	
}
