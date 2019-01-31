package GUI;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

import OBJParser.*;
import SoftwareRenderer.Matrix3;
import SoftwareRenderer.Triangle;
import SoftwareRenderer.Vertex;


public class DemoViewer {
	
	public static void main(String[] args) throws Exception {
		//Test ObjParser
		ObjParser parser = new ObjParser("C:\\Users\\Jason\\Desktop\\cubePrimitive.obj", true);
		parser.LoadObject();
		
		parser.ScaleVertices(100);
		parser.MakeTriangles();
		
		JFrame frame = new JFrame();
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());
		
		frame.setSize(512, 512);
		frame.setResizable(true);
		frame.setVisible(true);

		
		//Slider to control Horizontal Rotation
		JSlider headingSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 360, 0);
		pane.add(headingSlider, BorderLayout.SOUTH);
		
		//Slider to control Vertical Rotation
		JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, 0, 360, 0);
		pane.add(pitchSlider, BorderLayout.EAST);
		
		//Panel to display render results
		JPanel renderPanel = new JPanel() {
			double xOffset, yOffset;
			
			public void paintComponent(Graphics g) {
				xOffset = 0;
				yOffset = 25;
				
				Graphics2D g2 = (Graphics2D) g;
				//g2.scale(2, 2);				
				g2.setColor(Color.BLACK);
				
				g2.fillRect(0, 0, getWidth(), getHeight());
				
				
				
				
				List<Triangle> tris = parser.GetAllTris();
				
				double heading = Math.toRadians(headingSlider.getValue());
				Matrix3 headingTransform = new Matrix3(new double[] {
				        Math.cos(heading), 0, -Math.sin(heading),
				        0, 1, 0,
				        Math.sin(heading), 0, Math.cos(heading)
				    });
				double pitch = Math.toRadians(pitchSlider.getValue() + 180);
				Matrix3 pitchTransform = new Matrix3(new double[] {
				        1, 0, 0,
				        0, Math.cos(pitch), Math.sin(pitch),
				        0, -Math.sin(pitch), Math.cos(pitch)
				    });
				Matrix3 transform = headingTransform.multiply(pitchTransform);
				
				g2.translate(getWidth() / 2 + xOffset, getHeight() / 2 + yOffset);
				
				g2.setColor(Color.YELLOW);
				for (Triangle t : tris) {
				    Vertex v1 = transform.transform(t.v1);
				    Vertex v2 = transform.transform(t.v2);
				    Vertex v3 = transform.transform(t.v3);
				    
					Path2D path = new Path2D.Double();
				    path.moveTo(v1.x, v1.y);
				    path.lineTo(v2.x, v2.y);
				    path.lineTo(v3.x, v3.y);
				    path.closePath();
				    g2.draw(path);
				}
				
				
				
			}	
			
			
			
			
		};
		
		pane.add(renderPanel, BorderLayout.CENTER);
		
		headingSlider.addChangeListener(e -> renderPanel.repaint());
		pitchSlider.addChangeListener(e -> renderPanel.repaint());

	}

}





