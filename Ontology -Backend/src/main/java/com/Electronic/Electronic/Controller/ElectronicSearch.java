package com.Electronic.Electronic.Controller;

import net.minidev.json.JSONObject;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.Ontology;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Hasitha on 10/07/2019.
 */
@RestController
@CrossOrigin(origins = "*")
public class ElectronicSearch {

    @RequestMapping("/test")
    public String test(){
        return "Api Worked ";
    }

    @RequestMapping(value = "/ontologies",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<JSONObject> getontologies() {
        List<JSONObject> list=new ArrayList();
        String fileName = "ElectricAppliance_V6.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            Iterator ontologiesIter = model.listOntologies();
            while (ontologiesIter.hasNext()) {
                Ontology ontology = (Ontology) ontologiesIter.next();

                JSONObject obj = new JSONObject();
                obj.put("name", ontology.getLocalName());
                obj.put("uri",ontology.getURI());
                list.add(obj);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/GetBrand",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<org.json.simple.JSONObject> getBrand() {
        List<org.json.simple.JSONObject> list=new ArrayList();
        String fileName = "ElectricAppliance_V6.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String Brandquery="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX electric:<http://www.ElectricAppliance/OntologiesElectricAppliance.owl#>" +
                    "SELECT ?subject " +
                    "WHERE {" +
                    " ?subject rdf:type electric:Brand. " +
                    "} ORDER BY ASC(?subject)";

            Query query = QueryFactory.create(Brandquery);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();

            while (resultSet.hasNext()) {

                org.json.simple.JSONObject obj = new org.json.simple.JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("subject",solution.get("subject").toString());
                list.add(obj);
            }

            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    @RequestMapping(value = "/GetCountry",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<org.json.simple.JSONObject> getCountry() {
        List<org.json.simple.JSONObject> list=new ArrayList();
        String fileName = "ElectricAppliance_V6.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String Countryquery="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX electric:<http://www.ElectricAppliance/OntologiesElectricAppliance.owl#>" +
                    "SELECT ?subject " +
                    "WHERE {" +
                    "  ?subject rdf:type electric:ManufacturedCountry." +
                    "} ORDER BY ASC(?subject)";

            Query query = QueryFactory.create(Countryquery);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();

            while (resultSet.hasNext()) {

                org.json.simple.JSONObject obj = new org.json.simple.JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("subject",solution.get("subject").toString());
                list.add(obj);
            }

            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    @RequestMapping(value = "/GetUsageType",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<org.json.simple.JSONObject> getUsageType() {
        List<org.json.simple.JSONObject> list=new ArrayList();
        String fileName = "ElectricAppliance_V6.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String UsageTypequery="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX electric:<http://www.ElectricAppliance/OntologiesElectricAppliance.owl#>" +
                    "SELECT ?subject " +
                    "WHERE {" +
                    "  ?subject rdf:type electric:UsageType." +
                    "} ORDER BY ASC(?subject)";
            Query query = QueryFactory.create(UsageTypequery);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();

            while (resultSet.hasNext()) {

                org.json.simple.JSONObject obj = new org.json.simple.JSONObject();

                QuerySolution solution = resultSet.nextSolution();
                String usageType =solution.get("subject").toString();
                obj.put("subject", usageType);
                list.add(obj);
            }

            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    @RequestMapping(value = "/GetConsumerRate",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<org.json.simple.JSONObject> getConsumerRating() {
        List<org.json.simple.JSONObject> list=new ArrayList();
        String fileName = "ElectricAppliance_V6.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);

            String ConsumerRatequery="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX electric:<http://www.ElectricAppliance/OntologiesElectricAppliance.owl#>" +
                    "SELECT ?subject " +
                    "WHERE {" +
                    "  ?subject rdf:type electric:ConsumerRating. " +
                    "} ORDER BY ASC(?subject)" ;
            Query query = QueryFactory.create(ConsumerRatequery);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();

            while (resultSet.hasNext()) {

                org.json.simple.JSONObject obj = new org.json.simple.JSONObject();
                QuerySolution solution = resultSet.nextSolution();
                obj.put("subject",solution.get("subject").toString());
                list.add(obj);
            }

            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    @RequestMapping(path = "/GetSearch/{Brand}/{Country}/{UsageType}/{ConsumerRate}/{PriceFrom}/{PriceTo}", method = RequestMethod.GET)

    public List<org.json.simple.JSONObject> searchQuery(@PathVariable String Brand,@PathVariable String Country,@PathVariable String UsageType,@PathVariable String ConsumerRate,@PathVariable String PriceFrom, @PathVariable String PriceTo) {
        List<org.json.simple.JSONObject> list=new ArrayList();
        String fileName = "ElectricAppliance_V6.owl";
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            OntModel model = ModelFactory
                    .createOntologyModel(OntModelSpec.OWL_DL_MEM);
            model.read(reader,null);
            String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                    "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                    "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                    "PREFIX electric:<http://www.ElectricAppliance/OntologiesElectricAppliance.owl#> " +
                    "SELECT ?subject ?price " +
                    "WHERE { ";

            if (!(Brand.equals("replace")) )
                queryString += "?subject electric:hasBrand electric:" + Brand + ". ";//Brand
            if (!(Country.equals("replace")) )
                queryString += "?subject electric:hasCountry electric:" + Country + ". ";// Country
            if (!(UsageType.equals("replace")) )
                queryString += "?subject electric:hasUsageType electric:" + UsageType + ". ";// UsageType
            if (!(ConsumerRate.equals("replace")) )
                queryString += "?subject electric:hasConsumerRating electric:" + ConsumerRate + ".";// ConsumerRating
            if (!(PriceFrom.equals("replace") && (PriceTo.equals("replace"))))// price
                queryString += "?subject electric:hasPriceValue ?price. " +
                        "FILTER (?price > " + PriceFrom + " && ?price < " + PriceTo + ")}";
            else
            queryString += "?subject electric:hasPriceValue ?price.} ORDER BY ASC(?subject)";


            Query query = QueryFactory.create(queryString);
            QueryExecution qe = QueryExecutionFactory.create(query, model);
            ResultSet resultSet = qe.execSelect();

            while (resultSet.hasNext()) {
                org.json.simple.JSONObject obj = new org.json.simple.JSONObject();
                QuerySolution solution = resultSet.nextSolution();

                String priceResult =solution.get("price").toString();
                String price = priceResult.replace("^^http://www.w3.org/2001/XMLSchema#double", "  LKR /=");
                String Result=solution.get("subject").toString();
                String searchResult = Result.replace("_", "  ");
                obj.put("subject",searchResult);
                obj.put("price",price);
                list.add(obj);
            }

            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
