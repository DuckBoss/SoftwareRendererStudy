package SoftwareRenderer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class CubePrimitive {
	public List<Triangle> tris;
	
	public CubePrimitive() {
		tris = new ArrayList<>();
		
		Triangle tri_1 = new Triangle(
				new Vertex(0, 0, 1),
				new Vertex(1, 0, 1),
				new Vertex(0, 0, 0),
				Color.WHITE
				);
		tris.add(tri_1);
		Triangle tri_2 = new Triangle(
				new Vertex(0, 0, 0),
				new Vertex(1, 0, 1),
				new Vertex(1, 0, 0),
				Color.WHITE
				);
		tris.add(tri_2);
		Triangle tri_3 = new Triangle(
				new Vertex(0, 0, 0),
				new Vertex(0, 1, 0),
				new Vertex(0, 1, 1),
				Color.RED
				);
		tris.add(tri_3);
		Triangle tri_4 = new Triangle(
				new Vertex(0, 1, 1),
				new Vertex(0, 0, 1),
				new Vertex(0, 0, 0),
				Color.RED
				);
		tris.add(tri_4);
		Triangle tri_5 = new Triangle(
				new Vertex(0, 1, 0),
				new Vertex(1, 1, 1),
				new Vertex(0, 1, 1),
				Color.GREEN
				);
		tris.add(tri_5);
		Triangle tri_6 = new Triangle(
				new Vertex(0, 1, 0),
				new Vertex(1, 1, 1),
				new Vertex(1, 1, 0),
				Color.GREEN
				);
		tris.add(tri_6);
		Triangle tri_7 = new Triangle(
				new Vertex(1, 1, 0),
				new Vertex(1, 0, 1),
				new Vertex(1, 1, 1),
				Color.BLUE
				);
		tris.add(tri_7);
		Triangle tri_8 = new Triangle(
				new Vertex(1, 1, 0),
				new Vertex(1, 0, 1),
				new Vertex(1, 0, 0),
				Color.BLUE
				);
		tris.add(tri_8);
		Triangle tri_9 = new Triangle(
				new Vertex(0, 0, 1),
				new Vertex(0, 1, 1),
				new Vertex(1, 1, 1),
				Color.YELLOW
				);
		tris.add(tri_9);
		Triangle tri_10 = new Triangle(
				new Vertex(0, 0, 1),
				new Vertex(1, 0, 1),
				new Vertex(1, 1, 1),
				Color.YELLOW
				);
		tris.add(tri_10);
		Triangle tri_11 = new Triangle(
				new Vertex(0, 0, 0),
				new Vertex(1, 1, 0),
				new Vertex(0, 1, 0),
				Color.ORANGE
				);
		tris.add(tri_11);
		Triangle tri_12 = new Triangle(
				new Vertex(0, 0, 0),
				new Vertex(1, 1, 0),
				new Vertex(1, 0, 0),
				Color.ORANGE
				);
		tris.add(tri_12);
	}
	
	
}
