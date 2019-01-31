package OBJParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;
import java.io.*;
import SoftwareRenderer.*;

public class ObjParser {
	private List<Vertex> allVerts;
	private List<Triangle> allTris;
	private List<VertexOrder> vertOrders;
	private String objName;
	public boolean debug;
	
	public String filePath;

	public ObjParser() { 
		Init();
	}
	
	public ObjParser(String filePath) {
		this.filePath = filePath; 
		Init();
	}
	
	public ObjParser(String filePath, boolean debug) {
		this.filePath = filePath; 
		this.debug = debug;
		Init();
	}
	
	private void Init() {
		allVerts = new ArrayList<>();
		allTris = new ArrayList<>();
		vertOrders = new ArrayList<>();
	}
	
	public void LoadObject() throws Exception {
		File file = new File(filePath);
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String stLine;
		String[] splitVals;
		while( (stLine = br.readLine()) != null) {
			splitVals = stLine.split(" ");
			
			if((splitVals[0]).equals("o")) {
				objName = splitVals[1];
				if(debug) System.out.println(objName);
			}
			if((splitVals[0]).equals("v")) {
				Vertex vert = new Vertex(Double.parseDouble(splitVals[1]),Double.parseDouble(splitVals[2]), Double.parseDouble(splitVals[3]));
				allVerts.add(vert);
			}
			if((splitVals[0]).equals("f")) {
				VertexOrder vertOrd;
				if(splitVals.length == 5) {
					splitVals[1] = splitVals[1].split("/")[0];
					splitVals[2] = splitVals[2].split("/")[0];
					splitVals[3] = splitVals[3].split("/")[0];
					splitVals[4] = splitVals[4].split("/")[0];
					
					vertOrd = new VertexOrder(Integer.parseInt(splitVals[1]), Integer.parseInt(splitVals[2]), Integer.parseInt(splitVals[3]));
					vertOrders.add(vertOrd);
					vertOrd = new VertexOrder(Integer.parseInt(splitVals[1]), Integer.parseInt(splitVals[3]), Integer.parseInt(splitVals[4]));
					vertOrders.add(vertOrd);
				}
				if(splitVals.length == 4) {
					splitVals[1] = splitVals[1].split("/")[0];
					splitVals[2] = splitVals[2].split("/")[0];
					splitVals[3] = splitVals[3].split("/")[0];
					
					vertOrd = new VertexOrder(Integer.parseInt(splitVals[1]), Integer.parseInt(splitVals[2]), Integer.parseInt(splitVals[3]));
					vertOrders.add(vertOrd);
				}
			}
			if(debug) System.out.println(Arrays.toString(splitVals));
		}
		
		br.close();
	}
	
	public void MakeTriangles() {
		for(int i = 0; i < vertOrders.size(); i++) {
			Triangle tri;
			VertexOrder ord = vertOrders.get(i);
			tri = new Triangle(allVerts.get(ord.x-1), allVerts.get(ord.y-1), allVerts.get(ord.z-1), Color.WHITE);
			allTris.add(tri);
		}
	}
	
	public void ScaleVertices(float scaleAmnt) {
		for(Vertex vert : allVerts) {
			vert.ScaleVertex(scaleAmnt, scaleAmnt, scaleAmnt);
		}
	}
	
	public String GetObjName() {
		return objName;
	}
	
	public List<Vertex> GetAllVerts() {
		return allVerts;
	}
	
	public List<Triangle> GetAllTris() {
		return allTris;
	}
}

class VertexOrder {
	public int x;
	public int y;
	public int z;
	
	public VertexOrder() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public VertexOrder(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
