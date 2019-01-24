package it.unical.SPARQLTest;

import java.util.List;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

/**
 * Hello world!
 *
 */
public class SPARQLTest {
	public static void main(String[] args) {
		final String query = "PREFIX skos: <http://www.w3.org/2004/02/skos/core#>PREFIX crm: <http://erlangen-crm.org/current/>PREFIX crm: <http://www.cidoc-crm.org/cidoc-crm/>PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>PREFIX dbo: <http://dbpedia.org/ontology/>PREFIX dbp: <http://dbpedia.org/property/>PREFIX umbel-rc: <http://umbel.org/umbel/rc/>	PREFIX foaf: <http://xmlns.com/foaf/0.1/>PREFIX yago: <http://dbpedia.org/class/yago/>\r\n"
				+ "SELECT DISTINCT  ?outputLabel ?output\r\n" + "WHERE\r\n"
				+ "  { ?output  dbo:author  <http://dbpedia.org/resource/J._K._Rowling> ;\r\n"
				+ "             foaf:name   ?outputLabel\r\n" + "  }";
		List<QuerySolution> querySolution;
		final QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		System.out.println(query);
		try {
			final ResultSet results = queryExecution.execSelect();
			querySolution = ResultSetFormatter.toList(results);

		} finally {
			queryExecution.close();
		}
		for (QuerySolution solution : querySolution) {
			System.out.println(solution);
		}
	}
}
