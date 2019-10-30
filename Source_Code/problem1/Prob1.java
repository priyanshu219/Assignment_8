//package com.example.dijkstraimplementation;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.Attribute;
import org.jgrapht.io.EdgeProvider;
import org.jgrapht.io.GmlExporter;
import org.jgrapht.io.GmlImporter;
import org.jgrapht.io.VertexProvider;

public class Prob1 {

    private static String filePath = "/home/priyanshu/Documents/L8_Priyanshu_Garg_18114058/L8_P1_sample.gml";

    public static void main(String[] args) throws Exception {
        Graph<Integer, DefaultWeightedEdge> g = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        VertexProvider<Integer> vp = new VertexProvider<Integer>() {
            @Override
            public Integer buildVertex(String string, Map<String, Attribute> map) {
                return Integer.parseInt(string);
            }
        };
        EdgeProvider<Integer,DefaultWeightedEdge> ep = new EdgeProvider<Integer, DefaultWeightedEdge>() {
            @Override
            public DefaultWeightedEdge buildEdge(Integer v, Integer v1, String string, Map<String, Attribute> map) {
                 return new DefaultWeightedEdge();
            }
        };
        GmlImporter<Integer, DefaultWeightedEdge> gmlImporter = new GmlImporter<>(vp, ep);
        gmlImporter.importGraph(g, new File(filePath));
        GmlExporter<Integer,DefaultWeightedEdge> exporter = new GmlExporter<>();
        Writer writer = new StringWriter();
        exporter.exportGraph(g, writer);
        String graph1AsGraphML = writer.toString();
        
        // display
        System.out.println(graph1AsGraphML);
    }
}
