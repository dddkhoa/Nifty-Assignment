public class NBody {
	public static double readRadius(String filepath) {
		In in = new In(filepath);

		int nPlanets = in.readInt();
		double uniRadi = in.readDouble();
		return uniRadi;
	}

	public static Body[] readBodies(String filepath){
		In in = new In(filepath);
		int nPlanets = in.readInt();
		double uniRadi = in.readDouble();
		int i = 0;
		Body[] bodies = new Body[nPlanets];
		while (i<nPlanets){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			bodies[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
			i += 1;
		}
		return bodies;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);

		StdDraw.picture(0, 0, "./images/starfield.jpg");
		StdDraw.show();

		for (int i=0; i<bodies.length; i++) {
			bodies[i].draw();
		}

		StdAudio.play("./audio/2001.mid");

		double xForces[] = new double[bodies.length];
		double yForces[] = new double[bodies.length];

		for (double time=0; time<= T; time+=dt) {


			for (int i=0; i<bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}

			for (int i=0; i<bodies.length; i++) {
				bodies[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.setScale(-radius, radius);
			StdDraw.picture(0, 0, "./images/starfield.jpg");


			for (int i=0; i<bodies.length; i++) {
				bodies[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
		                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}

	}
}