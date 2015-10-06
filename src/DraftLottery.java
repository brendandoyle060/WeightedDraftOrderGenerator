import java.util.ArrayList;
import java.util.Random;

public class DraftLottery {

	Player sebastian = new Player("Sebastian", 20);
	Player dan = new Player("Dan", 14);
	Player brendan = new Player("Brendan", 12);
	Player megan = new Player("Megan", 10);
	Player carty = new Player("Carty", 9);
	Player cody = new Player("Cody", 9);
	Player becca = new Player("Becca", 9);
	Player kurt = new Player("Kurt", 9);
	Player gorms = new Player("Gorms", 8);
	Player max = new Player("Max", 7);
	Player zach = new Player("Zach", 6);
	Player brian = new Player("Brian", 5);
		
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Player> draftOrder = new ArrayList<Player>();
	
	private void initializePlayerList() {
		players.add(sebastian);
		players.add(dan);
		players.add(brendan);
		players.add(megan);
		players.add(carty);
		players.add(cody);
		players.add(becca);
		players.add(kurt);
		players.add(gorms);
		players.add(max);
		players.add(zach);
		players.add(brian);
		
		System.out.println("Number of players in league: " + players.size());
		System.out.println("Total of player odds: " + sumOfOdds() + "\n");
	}
	
	private int sumOfOdds() {
		int sumOfOdds = 0;
		for (Player player : players) {
			sumOfOdds += player.getOdds();
		}
		return sumOfOdds;
	}
	
	private int generateRandomNumber() {
		Random r = new Random();
		int randomInt = r.nextInt(sumOfOdds()) + 1;
		return randomInt;
	}
	
	private Player removeSelectionFromList(Player p) {
		players.remove(p);
		return p;
	}
	
	private void addSelectionToOrder(Player p) {
		draftOrder.add(p);
	}
	
	private Player determineSelection() {
		int rand = generateRandomNumber();
		
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getOdds() < rand) {
				rand -= players.get(i).getOdds();
			}
			else {
				return players.get(i);
			}
		}
		return null;
	}
	
	private void printOrder() {
		for(int i = 0; i < draftOrder.size(); i++) {
			System.out.println((i + 1) + ". " + draftOrder.get(i).getName());
		}
	}
	
	public static void main(String[] args) {
		DraftLottery dl = new DraftLottery();
		dl.initializePlayerList();
		
		int numberOfTeams = dl.players.size();
		
		for (int i = 0; i < numberOfTeams; i++) {
			Player pick = dl.determineSelection();
			dl.addSelectionToOrder(pick);
			dl.removeSelectionFromList(pick);
		}
		
		dl.printOrder();
		
	}

}
