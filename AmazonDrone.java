import java.util.*;
/*
Each breakfast delivery is assigned a unique ID, a positive integer. When one of the company's 100 drones takes off with a delivery, the delivery's ID is added to a list, delivery_id_confirmations. When the drone comes back and lands, the ID is again added to the same list.

After breakfast this morning there were only 99 drones on the tarmac. One of the drones never made it back from a delivery. We suspect a secret agent from Amazon placed an order and stole one of our patented drones. To track them down, we need to find their delivery ID.

Given the list of IDs, which contains many duplicate integers and one unique integer, find the unique integer.

The IDs are not guaranteed to be sorted or sequential. Orders aren't always fulfilled in the order they were received, and some deliveries get cancelled before takeoff.
*/
class AmazonDrone {
	public static void main(String args[])
	{
		String input = "1 2 3 1 3";
		System.out.println( "Ids marked by the drones: " + input);
		
		String[] strIdList = input.split(" ");
		Map<String, String> droneIdMap = new HashMap<String, String>();
		for(int i = 0; i < strIdList.length; i++)
		{
			if (droneIdMap.containsKey(strIdList[i]))
			{
				droneIdMap.remove(strIdList[i]);
			}
			else
			{
				droneIdMap.put(strIdList[i], strIdList[i]);
			}
		}
		for (String droneId : droneIdMap.keySet())
		{
			System.out.println("Offending drones: " + droneIdMap.get(droneId));
		}
	}
}
