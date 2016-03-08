# SemanticWebProject
 Built a web site of an athlete by collecting information from xml files of different ontologies. I have done it using java, JavaScript, html, Ajax.
 
 Steps to run the project

1. Load the project from "semanticwebproject" folder.


2. Add the Apache Jena Libraries to the Project by right clicking on the Project folder.
	
    Click on the Properties-> Java Build Path-> Add External JARS and select the Libraries from the 
	
    lib\ folder of the Project.


3. Open the finalproject.java file in eclipse and change the dataDir path to the file "Input.rdf"
   for the validation.


4. Execute the java file "finalproject.java" to validate the "Input.rdf" file and also to download    "file.rdf" containing informationabout Roger Federer from the link "http://dbpedia.org/data/Roger_Federer"

5. The "file.rdf" is downloaded and now combine both "Input.rdf" and "file.rdf" manually into a single file "combined_file.rdf".

6.Now Validate "combined_file.rdf" file again by changing the dataDir path to "combined_file.rdf".


7. After validating the "combined_file.rdf", open the Java file "finalproject_html.java" and change the path in FileManager.get().loadModel() to the path of the "combined_file.rdf"

8.Execute the "finalproject_html.java" file and "Index.html" file is generated with the information captured using SPARQL queries from the "combined_file.rdf" file finally.

9. Open the "Index.html" in a browser window to see the web page.

10.class files genereated are in the semanticwebproject\bin\semanticwebproject.

11.Java files are in semanticwebproject\src\semanticwebproject.
