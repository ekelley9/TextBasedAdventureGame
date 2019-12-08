import java.util.*;
public class Room 
{

//integers to keep track of n, s, e, w
	int northWall, eastWall, southWall, westWall;
	
// hashmap to keep track of Objects in the room
	private HashMap<String, Object> roomContents = new HashMap<>();
	
	public Room(int northWall, int eastWall, int southWall, int westWall) {
		Random rand = new Random();
		this.northWall = northWall;
		this.eastWall = eastWall;
		this.southWall = southWall;
		this.westWall = westWall;
		if (rand.nextInt(100)  <= 40) {
			roomContents.put("LawMan", LawManFactory.lawFactory(rand.nextInt(5) + 1));
		}
		if (rand.nextInt(100) <= 20) {
			roomContents.put("Laser Grid", 1);
		}
		if (rand.nextInt(100) <= 20) {
			roomContents.put("Med Kit", 1);
		}
		if (rand.nextInt(100) <= 15) {
			roomContents.put("Map Fragment", 1);
		}
		if (rand.nextInt(100)  <= 1) {
			roomContents.put("Waldo", 1);
		}

	}
	
	public HashMap getContents() {
		return roomContents;
	}
	
	public void setContents(HashMap contents) {
		this.roomContents = contents;
	}
	
	public boolean isDoor(int wall) {
		return wall == 1;
	}
	
	public String roomTop() {
		String top = "";
		if(this.isDoor(northWall)) {
			top = "* - *"; 
		}else {
			top = "* * *";
		}
		return "\n" + top;
	}
	
	public String roomMid() {
		String east = "";
		String west = "";
		String object = "";
		if(this.isDoor(this.westWall)) {
			west = "| ";
		}else {
			west = "* ";
		}
		
		if(this.roomContents.size() > 1) {
			object = "M";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("LawMan")) {
			object = "X";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Laser Grid")) {
			object = "L";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Map Fragment")) {
			object = "V";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Medic Kit")) {
			object = "H";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Waldo")) {
			object = "W";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Waldo")) {
			object = "P";
		}
		else {
			object = "E";
		}
		
		if(this.isDoor(this.eastWall)) {
			east = " |";
		}else {
			east= " *";
		}
		return "\n" + west + object + east;
	}
	
	public String roomBottom() {
		String bottom = "";
		
		if(this.isDoor(this.southWall)) {
			bottom = "* - *";
		}else {
			bottom = "* * *";
		}
		
		return "\n" + bottom;
	}

	

	public String toString() 
	{
		String result = this.roomTop() 
				 +  this.roomMid() 
				+this.roomBottom();

		return result;   
	}
}
