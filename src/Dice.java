import java.util.Scanner;

public class Dice {
	private int front = 2, back=5, top=1, bottom=6, left=3, right=4, n;
	String output="";
	Scanner scan;

	public Dice() {
		scan = new Scanner(System.in);
		System.out.println("What is number of dices ?");
		n = scan.nextInt();
		input(n);
	}
	
	public void input(int n){
		for (int i = 0; i<n; i++){
			System.out.println("F>Forward , B>Backward ,L>Left , R>Right ,C>Clockwise D>Counter-Clockwise");
			String input = scan.next();
			char[] sequence = input.toCharArray();
			start(sequence);
		}
		System.out.println("Front number : "+output);
	}
	public void start(char[]sequence) {
		
		for (int i = 0; i < sequence.length; i++) {
			char step = sequence[i];
			if (step == 'F' || step == 'f') {
				moveForward();
			}else if (step=='B'||step=='b'){
				moveBackward();
			}else if (step=='L'||step=='l'){
				moveLeft();
			}else if (step=='R'||step=='r'){
				moveRight();
			}else if (step=='C'||step=='c'){
				moveClockwise();
			}else if (step=='D'||step=='d'){
				moveCounter();
			}
		}
		output = output+front+" ";
		front = 2; back=5 ; top=1; bottom=6; left=3; right=4;
		
	}

	private void moveCounter() {
		front = swap(left,left=front);
		back = swap(right,right=back);
		right = swap(left,left=right);
		//System.out.println(top+""+bottom+""+left+""+right+""+front+""+back);
	}

	private void moveClockwise() {
		front = swap(right,right=front);
		back = swap (left,left=back);
		right = swap (left,left=right);
		//System.out.println(top+""+bottom+""+left+""+right+""+front+""+back);
	}

	private void moveRight() {
		top = swap(left,left=top);
		bottom = swap(right,right=bottom);
		right = swap (left,left=right);		
		//System.out.println(top+""+bottom+""+left+""+right+""+front+""+back);
	}

	private void moveLeft() {
		right = swap(top,top=right);
		left = swap (bottom,bottom=left);
		right = swap(left,left=right);
		//System.out.println(top+""+bottom+""+left+""+right+""+front+""+back);
	}

	private void moveBackward() {
		front = swap(bottom , bottom=front);
		top = swap(back,back=top);
		top = swap (bottom,bottom=top);
		//System.out.println(top+""+bottom+""+left+""+right+""+front+""+back);
	}

	private void moveForward() {
		front = swap(top ,top = front);
		back = swap(bottom,bottom = back);
		top = swap(bottom,bottom=top);	
		//System.out.println(top+""+bottom+""+left+""+right+""+front+""+back);
	}

	private int swap(int a, int b) {//using swap side of the dice	
		return a;
	}

}
