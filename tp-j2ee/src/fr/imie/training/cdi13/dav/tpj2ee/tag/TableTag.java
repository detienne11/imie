package fr.imie.training.cdi13.dav.tpj2ee.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TableTag extends SimpleTagSupport {

	private List<Object> list;

	private List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

	/*<table>
		<thead>
			<tr><th>col1</th><th>col2</th></tr>
		</thead>
		<tbody>
			<c:set var="nbMax" value="7"></c:set>
			<c:forEach var="j" begin="1" end="${nbMax}" step="1">
				<tr><td>Nb</td><td>${j}</td></tr>
			</c:forEach>
		</tbody>
	</table>*/
	
	@Override
	public void doTag() throws JspException, IOException {
		
		StringBuffer str = new StringBuffer();
		str.append("<table>\n");
		str.append("\t<caption>Tableau</caption>\n");
		str.append("\t<thead><tr><th>col1</th><th>col2</th></tr></thead>\n");
		str.append("\t<tbody>\n");
		List<Object> list = this.getList();
		if (list != null) {
			boolean pair = true;
			for (int i = 0; i < list.size(); i++) {
				str.append("\t\t<tr class=\"line ");
				pair = !pair;
				if (pair){					
					str.append("pair");
				}
				else {
					str.append("impair");
				}
				
				str.append("\"><td>ligne ");
				str.append(i+1);
				str.append("</td><td>");
				str.append(list.get(i).toString());
				str.append("</td></tr>\n");
			}
		}
		str.append("\t</tbody>\n");
		str.append("</table>\n");
		
		getJspContext().getOut().print(str.toString());
	}

}
