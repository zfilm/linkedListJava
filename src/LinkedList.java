class LinkedList{
	private Node head;
  	private int elements;
  	
	public LinkedList(){
		head = null;
		elements = 0;
	}
  	public boolean isEmpty(){				//Sjekker om lista er tom
  		if(head==null && elements==0){
  			return true;
  		}
  		else{
  			return false;
  		}
  	}
  	public boolean haveNumber(int X){
  			Node cp = null;
  			cp = head;
  			while(cp != null){
  				if(X==cp.element){
  					return true;
  				}
  			cp=cp.next;
  			}
  			return false;
  	}
  	public void deleteFirstElement(){		//1.Slett det forste elementet i listen.
  			head = head.next;					//setter head sin neste som den nye head
  			elements--;							//trekker fra en på elements
  	}
  	public void deleteLastElement(){		//2.Slett det siste elementet i listen.
  		if(elements==1){ 					//Hvis listen kun har en forekomst slettes denne..
  			head=null; 						//forekomsten slettes. (head blir null)
  			elements--;						//elements blir en mindre
  		}
  		else if(head.next!=null){			//Hvis head sin next ikke er null
  			Node cp = null;					//lager current pointer
  			Node pp = null;					//lager previous pointer
  			cp = head;						//peker current pointer til head
  			while(cp.next != null){			//så lenge current pointer sin next ikke er null
  				pp = cp;					//previous pointer blir current pointer
  				cp=cp.next;					//current pointer hopper til neste node.
  			}
  		pp.next=null;				//Previous pointer blir satt til null slik at det siste elemente blir borte.
  		elements--;					//elements blir en mindre
  		}
  	}  		  	
  	public void deleteThisElement(int x){	//3.Slett et elementet med oppgitt verdi fra listen (slett kun første forekomst)			
  				Node cp ;						//lager current pointer
  				Node pp = null;						//lager previous pointer
  				cp = head;
  				while(cp.element != x){
  					pp = cp;
  					cp=cp.next;
  				}
  		if(pp==null){							//Hvis oppgitt verdi er første element i lista.
  			head=cp.next;						//setter head som cp sin neste.
  		}
  		else{									
  			pp.next=cp.next;					//Hvis ikke settes pp sin neste til cp sin neste.
  		}
  	elements--;									//elements blir en mindre
  	}
  	public void insertAtFront(int x){		//4.Legg til et elementet med oppgitt verdi i starten av listen.
  		Node newNode = new Node();					//lager ny node
  		newNode.element = x;						//setter ny node sitt element til x
  		newNode.next = head;						//setter newNode sin neste til head
  		head = newNode;								//setter head til new node
  		elements++;									//Legger til elements med en
  	}
  	public void insertAtEnd(int x){ 		//5.Legg til et elementet med oppgitt verdi i slutten av listen. 
  		Node newNode = new Node(); 				//Lager en ny node
  		newNode.element = x; 					//Setter elements i den nye noden til x
  		newNode.next = null; 					//Setter den ny noden sin next til null
  			if(head == null){  					//Hvis listen er tom
  				head = newNode; 				//Liste er tom.. ny node blir head.
  			}
  			else{
  				Node cp;  						//Lager current pointer
  				cp = head; 
  				while (cp.next != null) 		//Sjekker om cp sin next er null, da er vi på slutten av lista.
  					cp=cp.next;  				//Går til neste node
  					cp.next= newNode;			//Setter den nye noden som den siste. 
  				
  			}
  		elements++;  					//Legger til elements med en.
  	}
  	public void insertAfterThisElement(int x,int y){	//6.Legg til et elementet etter et element med oppgitt verdi. (gjøres en gang)					
  			Node cp;
  			cp=head;
			while (cp!=null){
					if(cp.element==x){
  						
  						if(cp.next==null){					//hvis elementet det siste i lista
  							
  							Node newNode = new Node(); 		//Lager en ny node
  							newNode.element = y; 			//Setter elements i den nye noden til n
  	  					  	newNode.next=null;				//peker newNode på null (dette er nå siste element lista)
  	  					  	cp.next=newNode;				//current pointer peker nå til newNode
  	  					  	elements++;						//legger til elements med en
  	  					  	break;
  	  					}
  						else{								//hvis ikke elementet er det siste i lista
  							
  							Node newNode = new Node(); 		//Lager en ny node
  							newNode.element = y; 			//Setter elements i den nye noden til n
  							newNode.next=cp.next;			//peker newNode til cp sin neste
  							cp.next=newNode;				//current pointer peker nå til newNode
  							elements++;						//legger til elements med en
  							break;
  						}
  					}
  					else{
  						
  						cp=cp.next;							//går videre i lista
  					}	
			}
  	}
  	public void insertBeforeThisElement(int x,int y){	//7.Legg til et elementet foran et element med oppgitt verdi. (gjøres en gang)								
  			Node cp,pp;
  			cp=head;
  			pp=cp;
  			int counter=0;
 
  			while (cp!=null){
				if(cp.element==x){				//går igjennom lista til den finner elementet.
						
						if(cp.next==null||counter==0){			//hvis elementet det siste eller første i lista

							if(elements==1||counter==0){		//Hvis elementet er det første

								Node newNode = new Node(); 			//Lager en ny node
								newNode.element = y; 				//Setter elements i den nye noden til n
								head = newNode;						//setter den nye node som første element
	  			  				newNode.next=cp;					//peker newNode sin neste på current pointer
		  					  	elements++;							//legger til elements med en
		  					  	break;
							}
							else {								//Hvis elementet er det siste lista.				
								
								Node newNode = new Node(); 			//Lager en ny node
								newNode.element = y; 				//Setter elements i den nye noden til n
								pp.next=newNode;					//setter den nye node som første element
  			  					newNode.next=cp;					//peker newNode sin neste på current pointer
  			  					elements++;							//legger til elements med en
  			  					break;
							}
	  					}
						else{								//elementet er ikke det siste eller første i lista
							
							Node newNode = new Node(); 				//Lager en ny node
							newNode.element = y; 					//Setter elements i den nye noden til n
							newNode.next=cp;						//peker newNode sin neste på current pointer
  							pp.next=newNode;						//previous pointer sin neste blir newNode
							elements++;								//legger til elements med en
							break;
						}
					}
					else{									//går videre i lista
						
						pp=cp;								
						cp=cp.next;							
						counter++;							//Teller antall ganger 
					}	
  			}
}
  	public void size(){    					//8.Skriver ut lengden på listen.  		
 		 System.out.println("Antall elementer i listen er:" + elements);
 	}
  	public int countANumber(int x){			//9. Tell opp antall forekomster av element med gitt verdi i lista, dette antallet skrives ut.
  		int counter=0;							 			//setter counter til 0
  		Node cp;								 			//lager en current pointer
  		cp=head;								 			//setter current pointer lik head
  		while(cp!=null){ 									//sjekker igjennom hele listen.
  			if(cp.element==x){								//sjekker om hvert element om det er lik inputen.
  				counter++;									//legger på counter med en
  			}
  		cp=cp.next;											//går til neste node
  		}
  		
  	return counter;		//returnerer antall av element
  	}
  	public void printList(){ 				//10.Skriver ut hele listen.
     	Node cp;
   		cp = head;
   		int counter = 0;
   		while (cp != null){
   			System.out.print(" " + cp.element);
   			cp=cp.next;
   			counter++;
   			if(counter %5 == 0)System.out.print("\n");
 		} 		
  	}
  	public int deleteEntireList(){  		//11.Slette hele listen. Hvor mange elementer som ble slettet, skrives ut i main.
  		int counter=elements;
  		head=null;
  		elements=0;
  		return counter;
  	}

  	
} //class LinkedList
