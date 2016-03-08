package semanticwebproject;

import java.io.*;
import org.apache.jena.iri.impl.Main;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.util.FileManager;

public class finalproject_html {

	public static void show(String s) throws IOException {

		try {

			FileManager.get()
					.addLocatorClassLoader(Main.class.getClassLoader());
			Model model = FileManager
					.get()
					.loadModel(
							"D:/Bhavana/Summer_Semester/Semantic_web/combined_file.rdf");
			String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
					+ "PREFIX aboutplayer: <http://www.schema.org#>"
					+ "PREFIX j.0: <http://www.schema.org/>"
					+ "SELECT ?gender ?name ?spouse ?familyName ?birthPlace ?Nationality ?height ?birthdate ?weight ?PostalCode "
					+ "?addressRegion ?addressLocality ?addressCountry WHERE {  "
					+ "aboutplayer:Roger_Federer aboutplayer:gender ?gender . "
					+ "aboutplayer:Roger_Federer aboutplayer:givenName ?name . "
					+ "aboutplayer:Roger_Federer aboutplayer:spouse ?spouse . "
					+ "aboutplayer:Roger_Federer aboutplayer:familyName ?familyName . "
					+ "aboutplayer:Roger_Federer aboutplayer:birthPlace ?birthPlace . "
					+ "aboutplayer:Roger_Federer aboutplayer:height ?height . "
					+ "aboutplayer:Roger_Federer aboutplayer:Nationality ?Nationality . "
					+ "aboutplayer:Roger_Federer aboutplayer:birthdate ?birthdate . "
					+ "aboutplayer:Roger_Federer aboutplayer:weight ?weight . "
					+ "aboutplayer:rogerfederer_postaladdress aboutplayer:postalCode ?PostalCode ."
					+ "aboutplayer:rogerfederer_postaladdress aboutplayer:addressRegion ?addressRegion ."
					+ "aboutplayer:rogerfederer_postaladdress aboutplayer:addressLocality ?addressLocality ."
					+ "aboutplayer:rogerfederer_postaladdress aboutplayer:addressCountry ?addressCountry ."
					+ "}";

			Query query = QueryFactory.create(queryString);
			QueryExecution qexec = QueryExecutionFactory.create(query, model);
			ResultSet results = qexec.execSelect();
			QuerySolution qs = results.nextSolution();

			String name = qs.getLiteral("?name").toString();
			String gender = qs.getLiteral("?gender").toString();
			String spouse_temp = qs.getResource("?spouse").toString();
			String spouse = spouse_temp.substring(spouse_temp.lastIndexOf("/") + 1);
			String height = qs.getLiteral("?height").toString();
			String familyName = qs.getLiteral("?familyName").toString();
			String birthPlace_temp = qs.getResource("?birthPlace").toString();
			String birthPlace = birthPlace_temp.substring(birthPlace_temp.lastIndexOf("/") + 1);
			String Nationality_temp = qs.getResource("?Nationality").toString();
			String Nationality = Nationality_temp.substring(Nationality_temp.lastIndexOf("/") + 1);
			String PostalCode = qs.getLiteral("?PostalCode").toString();
			String birthdate = qs.getLiteral("?birthdate").toString();
			String weight = qs.getLiteral("?weight").toString();
			String addressRegion = qs.getLiteral("?addressRegion").toString();
			String addressLocality = qs.getLiteral("?addressLocality")
					.toString();
			String addresscountry_temp = qs.getResource("?addressCountry")
					.toString();
			String addresscountry = addresscountry_temp.substring(addresscountry_temp.lastIndexOf("/") + 1);

			System.out.println("Name = " + name);
			System.out.println("Gender = " + gender);
			System.out.println("Height = " + height);
			System.out.println("spouse = " + spouse);
			System.out.println("familyName = " + familyName);
			System.out.println("birthPlace = " + birthPlace);
			System.out.println("Nationality = " + Nationality);
			System.out.println("Address");
			System.out.println("PostalCode = " + PostalCode);

			// string builder for html starts
			StringBuilder htmlBuilder1 = new StringBuilder();// string
			
			htmlBuilder1.append("<html>");
			htmlBuilder1.append("<head><title>Roger Federer</title>");
			htmlBuilder1.append("<style> body {font: 16px/20px sans-serif; margin: 10px; padding: 0; background-image: url(\"http://designshack.net/wp-content/uploads/ds-woodsite-3.jpg\");}  td{font-size:medium; font-family: \"sans-serif\", Georgia, Serif;}");
			htmlBuilder1.append(".clickme {background-color: #eee; border-radius: 4px; color: #666; display: block; margin-bottom: 5px; padding: 5px 10px; text-decoration: none;}");
			htmlBuilder1.append(".clickme:hover { text-decoration: underline;}");
			htmlBuilder1.append("a{ color: #660000; text-decoration: none;} a:hover { text-decoration: underline; color:#3300FF} span.highlight{background-color: #eee;border-radius: 4px;}");
			htmlBuilder1.append(".box { background-color: #ccc; font-size: 100%; border-radius: 4px; color: #333; "
					+ "margin: 5px 0; padding: 5px 10px; width: auto;}</style></head>");
			htmlBuilder1.append("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
			htmlBuilder1.append("<script>$(document).ready(function(){ $('.box').hide(); $( '#id1' ).show(); $('.clickme').each(function() {");
			htmlBuilder1.append("$(this).show(0).on('click', function(e) {e.preventDefault();"
					+ "$(this).next('.box').slideToggle('fast');});});});</script>");
			
			htmlBuilder1.append("<body>");
			htmlBuilder1.append("<h2 align='center'><span class='highlight'>&nbsp;Roger Federer &nbsp; </span></h2>");
			htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>Personal Information</b></a>");
			htmlBuilder1.append("<div class='box' id='id1'><div style='float:left;margin-left:100px;  width:500; margin-top:50px'><table border=\"1\"  align=\"center\">");
			htmlBuilder1.append("<tr><td>Name </td><td> " + name+"</td></tr>");
			htmlBuilder1.append("<tr><td>Gender </td><td> " + gender+"</td></tr>");
			htmlBuilder1.append("<tr><td>Height </td><td> " + height+"</td></tr>");
			htmlBuilder1.append("<tr><td>spouse  </td><td><a href = '"+spouse_temp+"' target='_blank'>"+spouse+"</td></a></tr>");
			htmlBuilder1.append("<tr><td>familyName </td><td> " + familyName+"</td></tr>");
			htmlBuilder1.append("<tr><td>birthPlace  </td><td><a href='"+birthPlace_temp+"' target='_blank'>" + birthPlace+"</a></td></tr>");
			htmlBuilder1.append("<tr><td>birthdate </td><td>" + birthdate+"</td></tr>");
			htmlBuilder1.append("<tr><td>weight </td><td>" + weight+"</td></tr>");
			htmlBuilder1.append("<tr><td>Nationality </td><td><a href='"+Nationality_temp+"' target='_blank'>"+Nationality+"</a></td></tr>");
			htmlBuilder1.append("<tr align='center'><td><b>Address Details</b></td></tr>");
			htmlBuilder1.append("<tr><td>Postal Code </td><td> " + PostalCode+"</td></tr>");
			htmlBuilder1.append("<tr><td>Address Region </td><td>  " + addressRegion+"</td></tr>");
			htmlBuilder1.append("<tr><td>Address Locality </td><td>" + addressLocality+"</td></tr>");
			htmlBuilder1.append("<tr><td>Address Country </td><td><a href='"+addresscountry_temp+"' target='_blank'>"+addresscountry+"</td></a></tr>");
			htmlBuilder1.append("</table></div><div><img align='center' src='http://l.yimg.com/ea/img/-/141126/roger_federer_monfils_400_1a7agen-1a7agk1.jpg?x=400&q=80&n=1&sig=dKx_hUntop7SiGIfOKC3rw--' height width='300' height='400'></div></div> ");
            
			// -------------------------htmlbuilder championinsinglemale
			// started----------------

			String queryString1 = "PREFIX dbpedia-owl:<http://dbpedia.org/ontology/>"
					+ "SELECT  ?x WHERE { ?x dbpedia-owl:championInSingleMale ?championInSingleMale . }";
			Query query1 = QueryFactory.create(queryString1);
			QueryExecution qexec1 = QueryExecutionFactory.create(query1, model);
			ResultSet results1 = qexec1.execSelect();

			htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>Championship's in Single Male</b></a>");
			htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");
			while (results1.hasNext()) {
					
			
				QuerySolution qs1 = results1.nextSolution();
				String name1 = qs1.getResource("?x").toString();
				String name2 = name1.substring(name1.lastIndexOf("/") + 1);
				htmlBuilder1.append("<tr><td><a href='" + name1 + "' target='_blank'>" + name2
						+ "</a></td></tr>");
				
				System.out.println(name2);
				
			}

			htmlBuilder1.append("</table></div>");
			// -------------------------htmlbuilder championinsinglemale
			// closed----------------

			// ------------------------htmlbuilder flagbearer
			// started--------------
			String queryString2 = "PREFIX dbpedia-owl:<http://dbpedia.org/ontology/>  SELECT  ?xy WHERE { "
					+ "?xy dbpedia-owl:flagBearer ?flagBearer . }";
			Query query2 = QueryFactory.create(queryString2);
			QueryExecution qexec2 = QueryExecutionFactory.create(query2, model);
			ResultSet results2 = qexec2.execSelect();

			htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>As a flagbearer</b></a>");
			htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");
			while (results2.hasNext()) {
				QuerySolution qs2 = results2.nextSolution();
				String name3 = qs2.getResource("?xy").toString();
				String name4 = name3.substring(name3.lastIndexOf("/") + 1);
				htmlBuilder1.append("<tr><td><a href='" + name3 + "' target='_blank'>" + name4
						+ "</a></td></tr>");

				System.out.println(name4);

			}
			htmlBuilder1.append("</table></div>");
			// String txt = "some sample text";
			// String lastWord = txt.substring(txt.lastIndexOf(" ")+1);
			// System.out.println("lastword"+lastWord);

			// ------------------------htmlbuilder flagbearer
			// ended--------------
			// ------------------------htmlbuilder caption started--------------

			String queryString3 = "PREFIX dbpprop: <http://dbpedia.org/property/>  SELECT  ?y1 WHERE { "
					+ "?y1 dbpprop:caption ?caption . }";
			Query query3 = QueryFactory.create(queryString3);
			QueryExecution qexec3 = QueryExecutionFactory.create(query3, model);
			ResultSet results3 = qexec3.execSelect();

			htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>Rodger's caption's</b></a>");
			htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");
		
			while (results3.hasNext()) {
				QuerySolution qs3 = results3.nextSolution();
				String name5 = qs3.getResource("?y1").toString();
				String name6 = name5.substring(name5.lastIndexOf("/") + 1);
				htmlBuilder1.append("<tr><td><a href='" + name5 + "' target='_blank'>" + name6
						+ "</a></td></tr>");

				System.out.println(name5);

			}
			htmlBuilder1.append("</table></div>");

			// ------------------------htmlbuilder caption ended--------------

			// ------------------------htmlbuilder silver started--------------

			String queryString5 = "PREFIX dbpprop: <http://dbpedia.org/property/>  SELECT  ?y3 WHERE { "
					+ "?y3 dbpprop:silver ?silver . }";
			Query query5 = QueryFactory.create(queryString5);
			QueryExecution qexec5 = QueryExecutionFactory.create(query5, model);
			ResultSet results5 = qexec5.execSelect();

			htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>List of Silver Medals</b></a>");
			htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");	
			while (results5.hasNext()) {
				QuerySolution qs5 = results5.nextSolution();
				String name9 = qs5.getResource("?y3").toString();
				String name10 = name9.substring(name9.lastIndexOf("/") + 1);
				htmlBuilder1.append("<tr><td><a href='" + name9 + "' target='_blank'>" + name10
						+ "</a></td></tr>");

				System.out.println(name9);

			}
			htmlBuilder1.append("</table></div>");

			// ------------------------htmlbuilder silver ended--------------
			// ------------------------htmlbuilder mostConsecutiveTitlesOpenEra
			// started--------------

			String queryString6 = "PREFIX dbpprop: <http://dbpedia.org/property/>  SELECT  ?y4 WHERE { "
					+ "?y4 dbpprop:mostConsecutiveTitlesOpenEra ?mostConsecutiveTitlesOpenEra . }";
			Query query6 = QueryFactory.create(queryString6);
			QueryExecution qexec6 = QueryExecutionFactory.create(query6, model);
			ResultSet results6 = qexec6.execSelect();

			htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>Most Consecutive Titles Open Era</b></a>");
			htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");	
			while (results6.hasNext()) {
				QuerySolution qs6 = results6.nextSolution();
				String name11 = qs6.getResource("?y4").toString();
				String name12 = name11.substring(name11.lastIndexOf("/") + 1);
				htmlBuilder1.append("<tr><td><a href='" + name11 + "' target='_blank'>" + name12
						+ "</a></td></tr>");

				System.out.println(name11);

			}
			htmlBuilder1.append("</table></div>");
			// ------------------------htmlbuilder mostConsecutiveTitlesOpenEra
			// ended--------------
			// ------------------------htmlbuilder after started--------------

			String queryString7 = "PREFIX dbpprop: <http://dbpedia.org/property/>  SELECT  ?y5 WHERE { "
					+ "?y5 dbpprop:after  ?after  . }";
			Query query7 = QueryFactory.create(queryString7);
			QueryExecution qexec7 = QueryExecutionFactory.create(query7, model);
			ResultSet results7 = qexec7.execSelect();
			

			htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>Similar Players after Roger</b></a>");
			htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");	
			while (results7.hasNext()) {
				QuerySolution qs7 = results7.nextSolution();
				String name13 = qs7.getResource("?y5").toString();
				String name14 = name13.substring(name13.lastIndexOf("/") + 1);
				htmlBuilder1.append("<tr><td><a href='" + name13 + "' target='_blank'>" + name14
						+ "</a></td></tr>");

				System.out.println(name13);

			}
			htmlBuilder1.append("</table></div>");

			// ------------------------htmlbuilder after ended--------------
			// ------------------------htmlbuilder rdf type started--------------
			String queryString8 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
					+ " SELECT  ?y6 WHERE {?x rdf:type ?y6 . }";
			Query query8 = QueryFactory.create(queryString8);
			QueryExecution qexec8 = QueryExecutionFactory.create(query8, model);
			ResultSet results8 = qexec8.execSelect();

			htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>See Also</b></a>");
			htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");	
		
			while (results8.hasNext()) {
				QuerySolution qs8 = results8.nextSolution();
				String name15 = qs8.getResource("?y6").toString();
				String name16 = name15.substring(name15.lastIndexOf("/") + 1);
				htmlBuilder1.append("<tr><td><a href='" + name15 + "' target='_blank'>" + name16
						+ "</a></td></tr>");

				System.out.println(name15);

			}
			htmlBuilder1.append("</table></div>");
			// ------------------------htmlbuilder rdf type ended--------------
/*			// ------------------------htmlbuilder same as started--------------
						System.out.println("\n-----------STARTING SAME AS----------------\n");
						String queryString9 = " PREFIX owl: <http://www.w3.org/2002/07/owl#> "
								+ "SELECT  ?y7 WHERE { ?x owl:sameAs ?y7 .}";
 
						Query query9 = QueryFactory.create(queryString9);
						QueryExecution qexec9 = QueryExecutionFactory.create(query9, model);
						ResultSet results9 = qexec9.execSelect();

						htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>Other Related Links to Roger</b></a>");
						htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");	
					
						while (results9.hasNext()) {
							QuerySolution qs9 = results9.nextSolution();
							String name17 = qs9.getResource("?y7").toString();
							
							String name18 = name17.substring(name17.lastIndexOf("/") + 1);
							//htmlBuilder1.append("<tr><td><a href='" + name18 + "'>" +"</a></td></tr>");
							htmlBuilder1.append("<tr><td><a href='"+name17+"' target='_blank'>"+name17
									+ "</a></td></tr>");

							System.out.println(name17);

						}
						htmlBuilder1.append("</table></div>");*/
						
						
						// ------------------------htmlbuilder wikiPageDisambiguates
						// started--------------

						String queryString4 = "PREFIX dbpedia-owl:<http://dbpedia.org/ontology/>"
								+ "SELECT  ?y2 WHERE { ?y2 dbpedia-owl:wikiPageDisambiguates ?wikiPageDisambiguates . }";
						Query query4 = QueryFactory.create(queryString4);
						QueryExecution qexec4 = QueryExecutionFactory.create(query4, model);
						ResultSet results4 = qexec4.execSelect();

						htmlBuilder1.append("<a href='#' align='center' class='clickme'><b>(Disambiguations)</b></a>");
						htmlBuilder1.append("<div class='box'><table border=\"1\"  align=\"center\">");			
						
						while (results4.hasNext()) {
							QuerySolution qs4 = results4.nextSolution();
							String name7 = qs4.getResource("?y2").toString();
							String name8 = name7.substring(name7.lastIndexOf("/") + 1);
							htmlBuilder1.append("<tr><td><a href='" + name7 + "' target='_blank'>" + name8
									+ "</a></td></tr>");

							System.out.println(name7);

						}htmlBuilder1.append("</table></div>");

						// ------------------------htmlbuilder wikiPageDisambiguates
						// ended--------------
						// ------------------------htmlbuilder same as ended--------------

			
			
			htmlBuilder1.append("</body>");
			htmlBuilder1.append("</html>");

			String htmlString = htmlBuilder1.toString();
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					"Index.html").getAbsoluteFile()));
			bw.write(htmlString);
			bw.close();

		} finally {
			// qexec.close();
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		show("combined_file.xml");

	}

}