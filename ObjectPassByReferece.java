class ObjClass {
	int x;
	int y;
}

class ObjectPassByReferece {

	void printObj(ObjClass localObj)
	{
		localObj.x = 100;
		System.out.println("In method, x = " + localObj.x);
	}	

	public static void main(String args[])
	{
		System.out.println("Hello");
		ObjClass obj = new ObjClass();
		obj.x = 50;
		System.out.println("Before calling printObj, x = " + obj.x);
		(new ObjectPassByReferece()).printObj(obj);
		System.out.println("After calling printObj, x = " + obj.x);
	}
}
