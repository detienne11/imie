package fr.imie.training.cdi13.dav.tptests.calcul;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticImpl implements Diagnostic {

	public List<Buse> buseList = null;
	
	private Acquisition service = null;
	
	public boolean state = false;
	
	public DiagnosticImpl() {
		super();
	}

	@Override
	public void setNbBuses(Integer nbBuse) {
		
		buseList = new ArrayList<>();
		
		for (int i = 0; i < nbBuse.intValue(); i++) {
			Buse buse = new Buse();
			buseList.add(buse);
		}		
	}

	@Override
	public void acquerir(Float pression) {
		
		for (int i = 0; i < buseList.size(); i++) {
			Buse buse = buseList.get(i);
			buse.setPression(service.lirePression(Integer.valueOf(i)));
		}
		
		for (Buse buse : buseList) {
			
			float b = buse.getPression().floatValue();
			
			if (pression.floatValue() > (b*1.1)
					|| pression.floatValue() < (b*0.9)) {
				state = false;
				break;
			}
			state = true;
		}
		
	}
	

}
