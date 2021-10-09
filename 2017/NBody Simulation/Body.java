public class Body {

	public final double G = 6.67e-11;

	public double xxPos, yyPos, xxVel, yyVel, mass;
	public String imgFileName;

	/* Creates an instance of the Body class which can represent 
	a planet, star, or various objects in this universe */
	public Body(double xP, double yP, double xV,
              double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img; 
	}

	/* Creates an identical Body object copy */
	public Body(Body b) {
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName; 
	}

	public double calcDistance(Body b) {
		double dx = b.xxPos - this.xxPos;
		double dy = b.yyPos - this.yyPos;
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

	public double calcForceExertedBy(Body b) {
		if (this.equals(b)) {
			return 0;
		}
		return  (G * this.mass * b.mass) / Math.pow(this.calcDistance(b),2);
	}

	public double calcForceExertedByX(Body b) {
		double dx = b.xxPos - this.xxPos;
		return calcForceExertedBy(b) * dx / calcDistance(b); 
	}

	public double calcForceExertedByY(Body b) {
		double dy = b.yyPos - this.yyPos;
		return calcForceExertedBy(b) * dy / calcDistance(b); 
	}

	public double calcNetForceExertedByX(Body[] allBodys) {
		double netForceX = 0;
		for (Body b: allBodys) {
			if (this.equals(b)) {
				continue;
			}
			netForceX += this.calcForceExertedByX(b);
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Body[] allBodys) {
		double netForceY = 0;
		for (Body b: allBodys) {
			if (this.equals(b)) {
				continue;
			}
			netForceY += this.calcForceExertedByY(b);
		}
		return netForceY;
	}

	public void update(double dt, double fX, double fY) {
		double accX = fX / this.mass;
		double accY = fY / this.mass;
		this.xxVel += dt * accX;
		this.yyVel += dt * accY;
		this.xxPos += dt * xxVel;
		this.yyPos += dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "./images/"+this.imgFileName);
	}
}


