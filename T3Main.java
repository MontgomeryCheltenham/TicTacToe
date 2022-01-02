import java.util.HashMap;
import java.util.Scanner;

public class T3Main {
	
	HashMap<Integer, String> fieldStates = new HashMap<Integer, String>();
	int fieldNo; String fieldState;
	String playerSign, cpuSign;
	Scanner input;
		
	public static void main(String[] args) {
		new T3Main();
	}
	
	public T3Main() {
		playerSign = "X"; cpuSign = "O";
		gameSetup();
		for(int f : fieldStates.keySet()) {
			while((fieldStates.get(f).equals("-"))) {
				movePlayer(); checkForWin(playerSign);
				moveCPU_AI(); checkForWin(cpuSign); 
				
//				moveCPU_AI(); checkForWin(cpuSign);
			}
		};
	}
	public void gameSetup() {
		for(int i=1; i<10; i++) { //game starts with empty fields
			fieldNo = i; fieldState = "-";
			fieldStates.put(fieldNo, fieldState);
		}
	}
	/* .matches("^[1-9]+[.]?[1-9]{0,1}$") */
	public void movePlayer() { 
		input = new Scanner(System.in);
		String playerIn = input.next();
		
		if(playerIn.matches("^[1-9]+[.]?[1-9]{0,1}$")){
			int playerField = Integer.parseInt(playerIn);
			if(playerField>0 && playerField<10) {
				if(!fieldStates.get(playerField).equals("-")){
					System.out.println("cannot make this move");
					movePlayer();
				} else if(fieldStates.get(playerField).equals("-")) {
					fieldStates.put(playerField, playerSign);
					for(int f : fieldStates.keySet()) { // print matrix
						System.out.print(fieldStates.get(f));
						if(f%3==0) { System.out.print("\n"); }
					}
				}
			} else if (playerField<1 || playerField>9){
				System.out.println("pls give a Nº 1 to 9");
				movePlayer();
			} else { System.out.println("Fatal Error"); input.close(); System.exit(0); }
		} else {
			System.out.println("pls give a Nº 1 to 9");
			movePlayer();
		}
	}
	public void moveCPU_random() {
		int rn = (int)(Math.random()*9+1);
		System.out.println(rn);
		if (fieldStates.get(rn).equals("-")) {
			fieldStates.put(rn, cpuSign);
		} else {
			for(int i=1; i<9; i++) {
				if(rn==9 || rn+i==9) {rn=1;}
				else if (fieldStates.get(rn+i).equals("-")) {
					fieldStates.put(rn+i, cpuSign);
					break;
				}
			}
		}
		
		for(int f : fieldStates.keySet()) { // print matrix
			System.out.print(fieldStates.get(f));
			if(f%3==0) { System.out.print("\n"); }
		}
	}
	public void moveCPU_AI() {
		//go for win - check for 2 cpu signs
		if(twoSigns(1,2,3,cpuSign)) { fieldStates.put(3, cpuSign); }
		else if(twoSigns(2,3,1,cpuSign)) { fieldStates.put(1, cpuSign); }
		else if(twoSigns(1,3,2,cpuSign)) { fieldStates.put(2, cpuSign); }
		else if(twoSigns(4,5,6,cpuSign)) { fieldStates.put(6, cpuSign); }
		else if(twoSigns(5,6,4,cpuSign)) { fieldStates.put(4, cpuSign); }
		else if(twoSigns(4,6,5,cpuSign)) { fieldStates.put(5, cpuSign); }
		else if(twoSigns(7,8,9,cpuSign)) { fieldStates.put(9, cpuSign); }
		else if(twoSigns(8,9,7,cpuSign)) { fieldStates.put(7, cpuSign); }
		else if(twoSigns(7,9,8,cpuSign)) { fieldStates.put(8, cpuSign); }
		else if(twoSigns(1,4,7,cpuSign)) { fieldStates.put(7, cpuSign); }
		else if(twoSigns(1,7,4,cpuSign)) { fieldStates.put(4, cpuSign); }
		else if(twoSigns(4,7,1,cpuSign)) { fieldStates.put(1, cpuSign); }
		else if(twoSigns(2,5,8,cpuSign)) { fieldStates.put(8, cpuSign); }
		else if(twoSigns(2,8,5,cpuSign)) { fieldStates.put(5, cpuSign); }
		else if(twoSigns(5,8,2,cpuSign)) { fieldStates.put(2, cpuSign); }
		else if(twoSigns(3,6,9,cpuSign)) { fieldStates.put(9, cpuSign); }
		else if(twoSigns(3,9,6,cpuSign)) { fieldStates.put(6, cpuSign); }
		else if(twoSigns(6,9,3,cpuSign)) { fieldStates.put(3, cpuSign); }
		else if(twoSigns(1,5,9,cpuSign)) { fieldStates.put(9, cpuSign); }
		else if(twoSigns(1,9,5,cpuSign)) { fieldStates.put(5, cpuSign); }
		else if(twoSigns(5,9,1,cpuSign)) { fieldStates.put(1, cpuSign); }
		else if(twoSigns(3,5,7,cpuSign)) { fieldStates.put(7, cpuSign); }
		else if(twoSigns(3,7,5,cpuSign)) { fieldStates.put(5, cpuSign); }
		else if(twoSigns(5,7,3,cpuSign)) { fieldStates.put(3, cpuSign); }
		//defense - check for 2 player signs
		else if(twoSigns(1,2,3,playerSign)) { fieldStates.put(3, cpuSign); }
		else if(twoSigns(2,3,1,playerSign)) { fieldStates.put(1, cpuSign); }
		else if(twoSigns(1,3,2,playerSign)) { fieldStates.put(2, cpuSign); }
		else if(twoSigns(4,5,6,playerSign)) { fieldStates.put(6, cpuSign); }
		else if(twoSigns(5,6,4,playerSign)) { fieldStates.put(4, cpuSign); }
		else if(twoSigns(4,6,5,playerSign)) { fieldStates.put(5, cpuSign); }
		else if(twoSigns(7,8,9,playerSign)) { fieldStates.put(9, cpuSign); }
		else if(twoSigns(8,9,7,playerSign)) { fieldStates.put(7, cpuSign); }
		else if(twoSigns(7,9,8,playerSign)) { fieldStates.put(8, cpuSign); }
		else if(twoSigns(1,4,7,playerSign)) { fieldStates.put(7, cpuSign); }
		else if(twoSigns(1,7,4,playerSign)) { fieldStates.put(4, cpuSign); }
		else if(twoSigns(4,7,1,playerSign)) { fieldStates.put(1, cpuSign); }
		else if(twoSigns(2,5,8,playerSign)) { fieldStates.put(8, cpuSign); }
		else if(twoSigns(2,8,5,playerSign)) { fieldStates.put(5, cpuSign); }
		else if(twoSigns(5,8,2,playerSign)) { fieldStates.put(2, cpuSign); }
		else if(twoSigns(3,6,9,playerSign)) { fieldStates.put(9, cpuSign); }
		else if(twoSigns(3,9,6,playerSign)) { fieldStates.put(6, cpuSign); }
		else if(twoSigns(6,9,3,playerSign)) { fieldStates.put(3, cpuSign); }
		else if(twoSigns(1,5,9,playerSign)) { fieldStates.put(9, cpuSign); }
		else if(twoSigns(1,9,5,playerSign)) { fieldStates.put(5, cpuSign); }
		else if(twoSigns(5,9,1,playerSign)) { fieldStates.put(1, cpuSign); }
		else if(twoSigns(3,5,7,playerSign)) { fieldStates.put(7, cpuSign); }
		else if(twoSigns(3,7,5,playerSign)) { fieldStates.put(5, cpuSign); }
		else if(twoSigns(5,7,3,playerSign)) { fieldStates.put(3, cpuSign); }
		//attack - 5 free, not using 2468 in 2nd move, use 2468 in 3rd move, check for 2cpu signs
		else if (fieldStates.get(5).equals("-")) { fieldStates.put(5, cpuSign); }
		else if (fieldStates.get(5).equals(cpuSign)&&(fieldStates.get(1).equals(cpuSign))
				&&!(fieldStates.get(4).equals(playerSign))) {
			fieldStates.put(4, cpuSign); }
		else if (fieldStates.get(5).equals(cpuSign)&&(fieldStates.get(3).equals(cpuSign))
				&&!(fieldStates.get(6).equals(playerSign))) {
			fieldStates.put(6, cpuSign); }
		else if (fieldStates.get(5).equals(cpuSign)&&(fieldStates.get(7).equals(cpuSign))
				&&!(fieldStates.get(4).equals(playerSign))) {
			fieldStates.put(4, cpuSign); }
		else if (fieldStates.get(5).equals(cpuSign)&&(fieldStates.get(9).equals(cpuSign))
				&&!(fieldStates.get(6).equals(playerSign))) {
			fieldStates.put(6, cpuSign); }
		else if (fieldStates.get(1).equals("-")) { fieldStates.put(1, cpuSign); }
		else if (fieldStates.get(3).equals("-")) { fieldStates.put(3, cpuSign); }
		else if (fieldStates.get(7).equals("-")) { fieldStates.put(7, cpuSign); }
		else if (fieldStates.get(9).equals("-")) { fieldStates.put(9, cpuSign); }
		else if (fieldStates.get(2).equals("-")) { fieldStates.put(2, cpuSign); }
		else if (fieldStates.get(4).equals("-")) { fieldStates.put(4, cpuSign); }
		else if (fieldStates.get(6).equals("-")) { fieldStates.put(6, cpuSign); }
		else if (fieldStates.get(8).equals("-")) { fieldStates.put(8, cpuSign); }
		else { System.out.println("error: cannot make a move"); }
		
		System.out.println("===");
		for(int f : fieldStates.keySet()) { // print matrix
			System.out.print(fieldStates.get(f));
			if(f%3==0) { System.out.print("\n"); }
		}
	}
	public boolean twoSigns(int a, int b, int c, String signToCheck) {
		if(fieldStates.get(a).equals(signToCheck)&&fieldStates.get(b).equals(signToCheck)
			&&fieldStates.get(c).equals("-")) {
			return true;
		}else return false;
	}
	public void checkForWin(String sign) {
		if(
			(fieldStates.get(1).equals(sign)&&fieldStates.get(2).equals(sign)&&fieldStates.get(3).equals(sign)) 
			||(fieldStates.get(4).equals(sign)&&fieldStates.get(5).equals(sign)&&fieldStates.get(6).equals(sign))
			||(fieldStates.get(7).equals(sign)&&fieldStates.get(8).equals(sign)&&fieldStates.get(9).equals(sign))
			||(fieldStates.get(1).equals(sign)&&fieldStates.get(4).equals(sign)&&fieldStates.get(7).equals(sign))
			||(fieldStates.get(2).equals(sign)&&fieldStates.get(5).equals(sign)&&fieldStates.get(8).equals(sign))
			||(fieldStates.get(3).equals(sign)&&fieldStates.get(6).equals(sign)&&fieldStates.get(9).equals(sign))
			||(fieldStates.get(1).equals(sign)&&fieldStates.get(5).equals(sign)&&fieldStates.get(9).equals(sign))
			||(fieldStates.get(3).equals(sign)&&fieldStates.get(5).equals(sign)&&fieldStates.get(7).equals(sign))
		){
			System.out.println(sign + " wins!"); input.close(); System.exit(0);
		}
		else if (isDraw(fieldStates, "-")) {
			System.out.println("it's a draw"); input.close(); System.exit(0);
		}
	}
	public boolean isDraw(HashMap<Integer, String> hm, String str) {
		if(hm.values().stream().noneMatch(s -> s.equals(str))) {
			return true;
		}
		return false;
	}
}
