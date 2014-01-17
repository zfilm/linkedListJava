import java.util.InputMismatchException;
import java.util.Scanner;

public class oblig1 {


	private static Scanner input;

	public static void main(String[] args) {
		int i=0;
		String isEmptyString = ("Listen er helt tom!");
		LinkedList list = new LinkedList();
		
		while(i==0){
			System.out.println("\n\n.........Meny..........\n");		
			System.out.println("1. Slett det første elementet i listen.");
			System.out.println("2. Slett det siste elementet i listen.");
			System.out.println("3. Slett et elementet med oppgitt verdi fra listen (slett kun første forekomst");
			System.out.println("4. Legg til et elementet med oppgitt verdi i starten av listen.");
			System.out.println("5. Legg til et elementet med oppgitt verdi i slutten av listen.");	
			System.out.println("6. Legg til et elementet etter et element med oppgitt verdi. (gjøres en gang)");
			System.out.println("7. Legg til et elementet foran et element med oppgitt verdi. (gjøres en gang)");
			System.out.println("8. Skriv ut lengden på listen.");
			System.out.println("9. Tell opp antall forekomster av element med gitt verdi i lista, dette antallet skrives ut.");
			System.out.println("10.Skriv ut hele listen. Maks 5 elementer pr linje.");
			System.out.println("11.Slett hele listen. Hvor mange elementer som ble slettet, skrives ut.");
			System.out.println("12.Avslutt program\n\n\n\n");
			
			input = new Scanner(System.in);  //Sjekker om input er et tall
			try{
				i = input.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Valget må være et tall fra 1-12\n");
				i = 0;
			}
			switch(i){
				case 1: if(list.isEmpty()==true)System.out.println(isEmptyString); //Sjekker om listen er tom
						else list.deleteFirstElement(); //1. Sletter det første elementet i listen.
						i=0;
						break;
				case 2: if(list.isEmpty()==true) System.out.println(isEmptyString); //Sjekker om listen er tom
						else list.deleteLastElement(); //2. Sletter det siste elementet i listen.
						i=0;
						break;
				case 3: if(list.isEmpty()==true) System.out.println(isEmptyString); //Sjekker om listen er tom
						else{
							System.out.println("Oppgi verdi på element som skal slettes");
							Scanner input0 = new Scanner(System.in);
							int x0 = input0.nextInt(); 
							if(list.haveNumber(x0)==false) System.out.println("Nummeret er ikke i listen");
							else{
								list.deleteThisElement(x0); //3. Slett et elementet med oppgitt verdi fra listen (slett kun første forekomst
							}
						}
						i=0;
						break;
				case 4: System.out.println("Oppgi verdi på element som blir lagt til i front av listen.");
						Scanner input = new Scanner(System.in);
						int x = input.nextInt();
						list.insertAtFront(x); 	  //4. Legg til et elementet med oppgitt verdi i starten av listen.
						i=0;
						break;
				case 5: System.out.println("Oppgi verdi på elementet som blir lagt til i slutten av listen.");
						Scanner input1 = new Scanner(System.in);
						int x1 = input1.nextInt();
						list.insertAtEnd(x1); 	  //5. Legg til et elementet med oppgitt verdi i slutten av listen.
						i=0;
						break;
				case 6: if(list.isEmpty()==true) System.out.println(isEmptyString); //Sjekker om listen er tom
						else{
							System.out.println("Legg til et element etter et element med oppgitt verdi. Skriv hvilket tall verdien skal legges til etter.");
							Scanner input2 = new Scanner(System.in);
							int x2 = input2.nextInt();
							if(list.haveNumber(x2)==false){
								System.out.println("Nummeret er ikke i listen"); //sjekker om tallet er i lista
							}
							else{
								System.out.println("Legg til et element etter et element med oppgitt verdi. Skriv inn verdi?");
	  			  				Scanner input3 = new Scanner(System.in);
	  			  				int x3 = input3.nextInt();
								list.insertAfterThisElement(x2, x3); //6. Legg til et elementet etter et element med oppgitt verdi. (gjøres en gang)
							}
						}
						i=0;
						break;
				case 7:	if(list.isEmpty()==true) System.out.println(isEmptyString); //Sjekker om listen er tom
						else{
							System.out.println("Legg til et element før et element med oppgitt verdi. Skriv tallet verdien skal legges til foran.");
				  			Scanner input4 = new Scanner(System.in);
				  			int x4 = input4.nextInt();
				  			if(list.haveNumber(x4)==false){
								System.out.println("Nummeret er ikke i listen"); //sjekker om tallet er i lista
							}
							else{
								System.out.println("Legg til et element foran et element med oppgitt verdi. Skriv inn verdi?");
	  			  				Scanner input5 = new Scanner(System.in);
	  			  				int x5 = input5.nextInt();
	  			  				list.insertBeforeThisElement(x4,x5);//7. Legg til et elementet foran et element med oppgitt verdi. (gjøres en gang)
							}
						}
						i=0;
						break;
				case 8: list.size();   			  //8. Skriver ut lengden på listen.
						i=0;
						break;
				case 9: if(list.isEmpty()==true) System.out.println(isEmptyString); //Sjekker om listen er tom
						else{
							System.out.println("Oppgi verdi på element som skal telles."); //printer info til bruker
				  			Scanner input9 = new Scanner(System.in);  					   //tar input string fra bruker
				  			int x6 = input9.nextInt();				 					   //gjør om string til int
				  			int counter=list.countANumber(x6); 	  //9. Tell opp antall forekomster av element med gitt verdi i lista, dette antallet skrives ut.
							System.out.println("Antall elementer med verdien " + x6 + ": "+ counter);//printer ut antall av verdien
						}
						i=0;
						break;
				case 10:if(list.isEmpty()==true) System.out.println(isEmptyString); //Sjekker om listen er tom
						else{
							list.printList(); 		 //10. Skriver ut hele listen. Maks 5 elementer pr linje.
						}
						i=0;
						break;
				case 11:if(list.isEmpty()==true) System.out.println(isEmptyString); //Sjekker om listen er tom
						else{
							int deleted=list.deleteEntireList(); //11. Slett hele listen. Hvor mange elementer som ble slettet, skrives ut.
							System.out.println("Antall elementer som ble slettet " + deleted);
						}
						i=0;
						break;
				case 12:System.out.println("\n\nProgrammet er Avsluttet"); //12.Her avlutter programmet.
						i=1;
						break; 
				default:System.out.println("\n\nValg ikke tilgjengelig.\n"); //default action. 	
						i=0;
						break;
			}
		}
	}
}
