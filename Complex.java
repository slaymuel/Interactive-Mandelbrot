public class Complex{
	double ima;
	double rea;

	public Complex(){

	}

	public Complex(double rea, double ima){
		this.rea = rea;
		this.ima = ima;
	}

	public Complex add(Complex z){
		Complex sum = new Complex();
		sum.rea = this.rea + z.rea;
		sum.ima = this.ima + z.ima;
		return sum;
	} 

	public Complex multiply(Complex z){
		Complex prod = new Complex();
		prod.rea = this.rea * z.rea - this.ima * z.ima;
		prod.ima = this.ima * z.rea + this.rea * z.ima;
		return prod;
	}

	public double abs(){
		return Math.sqrt(Math.pow(this.rea, 2.0) + Math.pow(this.ima, 2.0));
	}

	public void print(){
		System.out.println(this.rea + " + " + this.ima + "i");
	}
}