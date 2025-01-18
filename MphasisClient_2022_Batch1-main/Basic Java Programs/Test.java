class Operation {
	void add(int x, int y) {
		System.out.println(x+y);
	}
	void add(int x, int y, int z) {
		System.out.println(x+y+z);
	}
	void add(float x, float y) {
		System.out.println(x+y);
	}
	void add(String x, String y) {
		System.out.println(x+y);
	}
}
class Test {
	public static void main(String args[]) {
	Operation op = new Operation();
	op.add(1,2,3);
	op.add(1,2);
		op.add("1","2");
	//op.add(10.10f,20.20f);
	//op.add((float)10.10,(float)20.20);
	double d1 = 10.10;
	double d2= 20.20;
	op.add((float)d1,(float)d2);	
	}
}