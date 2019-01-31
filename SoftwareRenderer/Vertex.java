package SoftwareRenderer;

public class Vertex {
	public double x;
	public double y;
	public double z;
	
	public Vertex(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vertex(Vertex vert) {
		this.x = vert.x;
		this.y = vert.y;
		this.z = vert.z;
	}
	
	public void EditVertex(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void ScaleVertex(double xFactor, double yFactor, double zFactor) {
		this.x *= xFactor;
		this.y *= yFactor;
		this.z *= zFactor;
	}
}
