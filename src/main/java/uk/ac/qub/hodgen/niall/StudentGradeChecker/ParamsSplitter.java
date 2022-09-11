package uk.ac.qub.hodgen.niall.StudentGradeChecker;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParamsSplitter {
    public ParamsSplitter() throws UnsupportedEncodingException {
    }

    public Map<String, String> splitQuery(String url) throws UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        String query = url;
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                    URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }

//    String query = "studentNumber=40040160&studentName=Niall%20Hodgen&programming=66&computingFoundations=66&databases=55&webDevelopment=66&softwareEngineering=66&dataAnalysis=66&userExperience=66&cloudComputing=66";
//
//
//    Map<String, String> hasher = splitQuery(query);
//    System.out.println(hasher);
//    System.out.println(hasher.get("studentNumber"));
}